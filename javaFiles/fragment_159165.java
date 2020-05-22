//plain lmbda
    expectsMethodRef( SomeObject::someMethod  );

    //with method object
    Method someMethod = SomeObject.class.getMethod("someMethod");        
    expectsMethodRef( (so) -> {
        try {
            return (String)someMethod.invoke(so);
        } catch (Exception e) {
            return null;
        }
    } );