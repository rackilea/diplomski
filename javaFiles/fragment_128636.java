abstract class DigitalCamera {
    private final Param param;
    protected DigitialCamera(Param param) {
        this.param = param;
    }
}
final class DSLR extends DigitalCamera {
    public DigitialCamera(Param param) {
        super(param); // <-- Call super's constructor.
    }
}