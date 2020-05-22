public class SfPojoDto {
    private String device;
    private List<Ifce> ifces;
}

public class Ifce {
    private String port;
    private String reservableBW;
    private String[] capabilites;
}