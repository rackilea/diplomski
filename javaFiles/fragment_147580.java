public static final TransferePatternable HARDLIM =
new TransferePatternable() {
    public DoubleMatrix transfere(MyObject obj) {
    return MyObjectUtilFun.hardlim(obj.getNetsum,obj.getTheta);
    }
    public String getFuncName() {
    return "HARDLIM";
    }
};