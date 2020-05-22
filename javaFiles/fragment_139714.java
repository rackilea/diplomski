public String doSomething( Object arg1, ... ) {

    Person p = ...load a person...;

    JSONSerializer serializer = new JSONSerializer();
    return serializer.serialize( p );
}

{
    "class": "Person",
    "name": "William Shakespeare",
    "birthday": -12802392000000,
    "nickname": "Bill"
}