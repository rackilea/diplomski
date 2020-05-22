public List<Foo> getFooForSomeFlow1(Param1 param1, Param2 param2, ...){
    FooResponse fooResponse = anotherService.baz(fooRequest);
    TransformerStrategy myTransformerStrategy = createTransformerStrategyWithABCValues(param2, param2, iVar1, iVar2);
    FooResponse fooResponse = getResponse(fooResponse, myTransformerStrategy);
    ...//other code
}