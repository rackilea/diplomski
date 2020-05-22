scalaObject.foo(new Left<String, scala.Function0<String>>("abc"));
scalaObject.foo(new Right<String, scala.Function0<String>>(
        new scala.Function0<String>() {
            @Override
            public String apply() {
                throw new RuntimeException();
            }
        }));