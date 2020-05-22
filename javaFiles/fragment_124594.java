public class MyClass {

    public enum MyEnum{
        TYPE1("Name", 9,1,100000), TYPE2("Name2", 10, 1, 200000);

        private final int androidVersion;
        private final int appVersionCode;
        private final int availableMemSize;
        private final String appVersionName;

        private MyEnum(String appVersionName, int androidVersion, int appVersionCode, int availableMemSize) {
            this.androidVersion = androidVersion;
            this.appVersionCode = appVersionCode;
            this.availableMemSize = availableMemSize;
            this.appVersionName = appVersionName;
        }
    }
    MyEnum mType = MyEnum.TYPE1;
}