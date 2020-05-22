public class PackageItem {
    private PackageInfo mPackageInfo;
    private String mName;

    public PackageItem(PackageInfo packageInfo, String name) {
        mPackageInfo = packageInfo;
        mName = name;
    }

    public String getName() {
        return mName;
    }
}