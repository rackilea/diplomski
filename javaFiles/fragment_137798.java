public class PreDefinedAttributes {
    private Context mContext;
    private String mobile_os, mobile_model, mobile_brand, mobile_version, mobile_manufacturer;
    private String sdk_version, src, appname, appversion;
    private String lat = "", lng = "", device_id;
    private static final int REQUEST_FINE_LOCATION = 0;
    private int height, width;


    public PreDefinedAttributes(Context context) {
        mContext = context;

        this.mobile_model = android.os.Build.MODEL;
        this.mobile_os = "Android";
        this.mobile_brand = Build.BRAND + " " + Build.PRODUCT;
        this.mobile_version = Build.VERSION.RELEASE;
        this.mobile_manufacturer = Build.MANUFACTURER;

        this.sdk_version = 16 + "";
        this.src = 16 + "";
        this.device_id = 16 + "";
        try {
            this.appversion = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0).versionName;
        } catch (Exception e) {
            this.appversion = "";
        }

        final PackageManager pm = mContext.getPackageManager();
        ApplicationInfo ai;
        try {
            ai = pm.getApplicationInfo(mContext.getPackageName(), 0);
        } catch (final PackageManager.NameNotFoundException e) {
            ai = null;
        }
        this.appname = (String) (ai != null ? pm.getApplicationLabel(ai) : "(unknown)");


        height = Resources.getSystem().getDisplayMetrics().heightPixels;
        width = Resources.getSystem().getDisplayMetrics().widthPixels;


        //loadPermissions(Manifest.permission.ACCESS_FINE_LOCATION,REQUEST_FINE_LOCATION);


    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getDevice_id() {
        return device_id;
    }

    public String getMobile_brand() {
        return mobile_brand;
    }


    public String getMobile_model() {
        return mobile_model;
    }

    public String getMobile_os() {
        return mobile_os;
    }

    public String getMobile_version() {
        return mobile_version;
    }

    public String getMobile_manufacturer() {
        return mobile_manufacturer;
    }

    public String getSdk_version() {
        return sdk_version;
    }

    public String getSrc() {
        return src;
    }

    public String getAppname() {
        return appname;
    }

    public String getAppversion() {
        return appversion;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }
}