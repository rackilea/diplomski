-- translation file (translation.txt)
func_70912_b,setTameSkin,2,
func_70913_u,getTameSkin,2,
func_70915_j,getShadingWhileShaking,2,Used when calculating the amount of shading to apply while the wolf is shaking.
func_70916_h,setAngry,2,Sets whether this wolf is angry.


-- obfuscated program (script.lua)
x:func_70913_u(y, z)
x:func_70915_j(y, z)


-- your preprocessor (preprocessor.lua)
local transl = {}
for line in io.lines'translation.txt' do
   local obf, orig = line:match'^(.-),(.-),'
   transl[obf] = orig
end
local script = assert(io.open('script.lua','rb')):read'*a'
local output = assert(io.open('script2.lua','wb'))
output:write((script:gsub('[%w_]+',transl)))
output:close()


-- preprocessor output (script2.lua)
x:getTameSkin(y, z)
x:getShadingWhileShaking(y, z)