protected static boolean installedFromMarket(WeakReference<? extends Context> weakContext) {
    boolean result = false;

    Context context = weakContext.get();
    if (context != null) {
        try {
            String installer = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            // if installer string is not null it might be installed by market
            if (!TextUtils.isEmpty(installer)) {
                result = true;

                // on Android Nougat and up when installing an app through the package installer (which HockeyApp uses itself), the installer will be
                // "com.google.android.packageinstaller" or "com.android.packageinstaller" which is also not to be considered as a market installation
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N && (TextUtils.equals(installer, INSTALLER_PACKAGE_INSTALLER_NOUGAT) || TextUtils.equals(installer, INSTALLER_PACKAGE_INSTALLER_NOUGAT2))) {
                    result = false;
                }

                // on some devices (Xiaomi) the installer identifier will be "adb", which is not to be considered as a market installation
                if (TextUtils.equals(installer, INSTALLER_ADB)) {
                    result = false;
                }
            }

        } catch (Throwable ignored) {
        }
    }

    return result;
}