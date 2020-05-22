List<PackageInfo> packages = getPackageManager().getInstalledPackages(0);
for(PackageInfo pack : packages)
{
   PackageInfo permissionInfo = null;  
    permissionInfo = getPackageManager().getPackageInfo(pack.packageName, PackageManager.GET_PERMISSIONS);
    if(permissionInfo != null){  
         String[] permissions = permissionInfo.requestedPermissions;
          //YOUR CODE HERE
      }
}