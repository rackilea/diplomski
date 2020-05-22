public static String findLauncherProviderAuthority(Context context) {
    // Gets PackageInfo about all installed apps
    final List<PackageInfo> packs = context.getPackageManager().getInstalledPackages(PackageManager.GET_PROVIDERS);
    if (packs == null) {
        return null;
    }

    for (PackageInfo pack : packs) {
        // This gets the ProviderInfo of every ContentProvider in that app
        final ProviderInfo[] providers = pack.providers;
        if (providers == null) {
            continue;
        }

        // This loops through the ContentProviders
        for (ProviderInfo provider : providers) {

            // And finally we look for the one with the correct permissions
            // We use `startsWith()` and `endsWith()` since only the middle 
            // part might change
            final String readPermission = provider.readPermission;
            final String writePermission = provider.writePermission;
            if(readPermission != null && writePermission != null) {
                final boolean readPermissionMatches = readPermission.startsWith("com.android.") && readPermission.endsWith(".permission.READ_SETTINGS");
                final boolean writePermissionMatches = writePermission.startsWith("com.android.") && writePermission.endsWith(".permission.WRITE_SETTINGS");
                if(readPermissionMatches && writePermissionMatches) {

                    // And if we found the right one we return the authority
                    return provider.authority;
                }
            }
        }
    }
    return null;
}