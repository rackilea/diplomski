interface ThirdPartyInterface1 {
}

interface ThirdPartyInterface2 {
}

interface MyInterface extends ThirdPartyInterface1, ThirdPartyInterface2 {
}

public class YourClass {
    private MyInterface attr;
}