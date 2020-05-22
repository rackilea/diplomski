local obfuscations = {}
for line in io.lines'translation.txt' do
   local obf, orig = line:match'^(.-),(.-),'
   obfuscations[orig] = obf
end

local function get_obf_key_value(t, k, __index)
   local value = __index and __index(t, k)
   if value == nil and obfuscations[k] then
      value = t[obfuscations[k]]
   end
   return value
end

local cache = {get_obf_key_value = true}

local function __index_constructor(__index)
   if not __index then
      return get_obf_key_value
   end
   local old__index = cache[__index]
   if old__index then
      return old__index == true and __index or old__index
   else
      local function new__index(t, k)
         return get_obf_key_value(t, k, __index)
      end
      cache[__index] = new__index
      cache[new__index] = true
      return new__index
   end
end

local obf_mt = {__index = get_obf_key_value}

local function correct_metatable(object)
   local mt = getmetatable(object)
   if mt == nil then
      setmetatable(object, obf_mt)
   else
      local __index = mt.__index
      if __index == nil or type(__index) == 'function' then
          mt.__index = __index_constructor(__index)
      else
         correct_metatable(__index)
      end
   end
end

-- you should call correct_metatable(class_or_object_of_that_class)
-- at least once for every class
correct_metatable(wolf)
correct_metatable(goat)
correct_metatable(cabbage)
...