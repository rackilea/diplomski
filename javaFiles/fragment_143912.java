public class SignGenerator {
    public static ISign getSignObject(String str1,String str2, String str3, String str4) {
        if(str1.equals("blah blah"))
           return new FirstType();
        if(str1.equals("blah blah2") && str2.equals("lorem ipsum"))
           return new SecondType();
        return new ThirdType();
    }
}

public class FirstType implements ISign {
}

public class SecondType implements ISign {
}

public class ThirdType implements ISign {
}