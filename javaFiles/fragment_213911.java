public class buildpartFooBar implement fooBarCommon{
//fooBarCommon is the interface the enforces the commonality of between the 2 objects.    

public buildPartFooBar(){...}

...[various setter methods here ....]

//make the different types of object we may become
private foo1 makeFoo1(iNeedThisToBeAFoo1 object){...}
private  foo2 makeFoo2(iNeedThisToBeAFoo2 object){...}
private  bar1 makeBar1(iNeedThisToBeABar1 object){...}
private  bar2 makeBar2 (iNeedThisToBeABar2 object){...}
private fooBarChimera makeChimera (){...}