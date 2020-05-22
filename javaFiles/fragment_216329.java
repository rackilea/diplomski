public interface Phone {
    String getNumber();
}

public interface MobilePhone extends Phone {
    public boolean isSmartPhone();
}