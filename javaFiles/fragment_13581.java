public interface ISample {

    static final ModeEnum DEFAULT_MODE = ModeEnum.FAIL_FAST;

    public void process(ModeEnum mode);

}