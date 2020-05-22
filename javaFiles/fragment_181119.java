String test = "TeSTStringOne";
System.out.println(
    Arrays.toString(
        //          | preceded by lowercase
        //          |        | followed by uppercase
        //          |        |       | or
        //          |        |       || preceded and followed by uppercase
        //          |        |       ||                  | or
        //          |        |       ||                  || preceded by uc
        //          |        |       ||                  || AND lowercase
        test.split("(?<=[a-z])(?=[A-Z])|(?<=[A-Z])(?=[A-Z])|(?<=[A-Z][a-z])")
    )
);