final PackageManager pm = getApplicationContext().getPackageManager();
ApplicationInfo ai;
try {
    ai = pm.getApplicationInfo( this.getPackageName(), 0);
} catch (final NameNotFoundException e) {
    ai = null;
}
final String applicationName = (String) (ai != null ? pm.getApplicationLabel(ai) : "(unknown)");