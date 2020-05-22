class Java::JavaUtil::Arrays
  boolean_array_class = [false].to_java(:boolean).java_class
  java_alias :boolean_equals, :equals, [boolean_array_class, boolean_array_class]
end

a1 = [false, true]
Java::JavaUtil::Arrays.boolean_equals a1, a1
# => TypeError: for method Arrays.equals expected [class [Z, class [Z]; got: [org.jruby.RubyArray,org.jruby.RubyArray]; error: argument type mismatch
Java::JavaUtil::Arrays.boolean_equals a1.to_java(:boolean), a1.to_java(:boolean)
# => true
a2 = [true, false]
Java::JavaUtil::Arrays.boolean_equals a1.to_java(:boolean), a2.to_java(:boolean)
# => false