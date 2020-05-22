declare IsTested
    name: String
end

rule "abc"
when 
    $obj : TestClass($name: name=="test", age != 20)
    not IsTested(name == $name)
then 
    TestClass $obj2 = new TestClass();
    $obj2.setName("test");
    $obj2.setAge(30);
    insert($obj2);
    insert(new IsTested($name));
end