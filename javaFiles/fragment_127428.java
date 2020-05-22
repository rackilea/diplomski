public static void withCollectArguments() throws Throwable {

        MethodHandle mh_minus      = MethodHandles.lookup().findStatic(
                TTest.class,
                "minus",
                MethodType.methodType(
                        double.class, // output
                        double.class, // arg1
                        double.class  // arg2
                )
        );

        MethodHandle mh_plus       =  MethodHandles.lookup().findStatic(
                TTest.class,
                "plus",
                MethodType.methodType(
                        double.class,
                        double.class,
                        double.class
                )
        );

        // this guys here is used in filters to do a MethodHandle.invoke() -> double conversion
        MethodHandle doubleInvoker = MethodHandles.exactInvoker(
                MethodType.methodType(
                        double.class
                )
        );

        // I want: f(x) = plus( minus( x, 2.0), 3.0) === (x - 2.0 ) + 3.0

        // mh_minus takes 2 doubles as input. The second one needs to
        // take a MethodHandle that returns a constant, so we filter
        MethodHandle x_minus_2 = MethodHandles.filterArguments(
                mh_minus,
                1,
                doubleInvoker
        );

        x_minus_2 = MethodHandles.insertArguments(
                x_minus_2,
                1,
                MethodHandles.constant(double.class, 2)
        );

        // this here is the magic: we collect arguments of mh_plus (double, double),
        // starting at argument index 0,and the collector is minus_2 ( double ) :
        // we will "eat" the first arg of mh_plus and replace it with minus_2
        MethodHandle x_minus_2_plus_y = MethodHandles.collectArguments(
                mh_plus,
                0,
                x_minus_2
        );

        // we then curry x_minus_2_plus_y with a constant as 2nd argument: y => 3
        MethodHandle x_minus_2_plus_3 = MethodHandles.filterArguments(
                x_minus_2_plus_y,
                1,
                doubleInvoker
        );

        // "( x - 2 ) + y" becomes "( x - 2 ) + 3"
        x_minus_2_plus_3 = MethodHandles.insertArguments(
                x_minus_2_plus_3,
                1,
                MethodHandles.constant(
                        double.class,
                        3
                )
        );

        // we now have a method handle that takes 1 argument and dispatches it to minus
        double res = (double)x_minus_2_plus_3.invokeExact(1.0); // performs ( x=1.0 - 2.0) + 3.0
        Assert.assertEquals(res, 2.0);

        res = (double)x_minus_2_plus_3.invokeExact(5.0); // performs ( x=5.0 -2.0 ) + 3.0
        Assert.assertEquals(res, 6.0);
    }