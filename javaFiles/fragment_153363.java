if(appInstalledOrNot(com.demo.package)){
    Toast.makeText(this,"App Installed",Toast.LENGTH_LONG).show();
} else {
    Toast.makeText(this,"App NOt Installed",Toast.LENGTH_LONG).show();
}
private boolean appInstalledOrNot(String packageName) {  
    PackageManager pm = this.getPackageManager();
    try {
        pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
        return true;
    } catch (Exception e) {
        Log.e("::MG::",""+e);
        return false;
    } 
}