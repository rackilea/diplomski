try { 
        PackageInfo packageInfo = getPackageManager().getPackageInfo(myPackageName, PackageManager.GET_PERMISSIONS);

        String[] requestedPermissions = packageInfo.requestedPermissions;
        if ( requestedPermissions != null ) {
            for (int i = 0; i < requestedPermissions.length; i++) {
              //permission.setSummary(requestedPermissions[i] + "\n");
              //method to create a preference with the name of your permission.  
              setPreference(this, requestedPermissions[i]);
            } 

        } 
    } 
    catch ( PackageManager.NameNotFoundException e ) {
        e.printStackTrace();
    }