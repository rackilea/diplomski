Object allowedApps= getLastCustomNonConfigurationInstance();
if (allowedApps != null) {
    this.allowedApps = (List<AppDetail>) allowedApps;
}else{
    this.allowedApps = new ArrayList<AppDetail>();
}