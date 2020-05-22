public class AppList extends Activity {
  ....
  private ArrayList results = new ArrayList();
  @Override
  public void onCreate(Bundle savedInstanceState) {
    .....
    PackageManager pm = this.getPackageManager();
    Intent intent = new Intent(Intent.ACTION_MAIN, null);
    intent.addCategory(Intent.CATEGORY_LAUNCHER);
    List list = pm.queryIntentActivities(intent, PackageManager.PERMISSION_GRANTED);
    for (ResolveInfo rInfo : list) {
       results.add(rInfo.activityInfo.applicationInfo.loadLabel(pm).toString());
       Log.w("Installed Applications", rInfo.activityInfo.applicationInfo.loadLabel(pm).toString());
  } 
 }
}