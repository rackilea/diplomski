doThrow(new IllegalStateException("failed"))
    .when(anotherThing.doSomething(anyString()));
//                    ^ BAD: Method call inside doVerb().when()

doThrow(new IllegalStateException("failed"))
    .when(anotherThing).doSomething(anyString());
//                    ^ GOOD: Method call after doVerb().when()