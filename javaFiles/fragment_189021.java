var
  PM: JPackageManager;
  mainIntent: JIntent;
  LaunchIntent: JIntent;
  pkgAppsList: JList;
  ri: JResolveInfo;
  iter: JIterator;
  midlist := TStringList;
begin
  PM := SharedActivityContext.getPackageManager;
  mainIntent := TJIntent.JavaClass.init(TJIntent.JavaClass.ACTION_MAIN, nil);
  mainIntent.addCategory(TJIntent.JavaClass.CATEGORY_LAUNCHER);
  pkgAppsList := PM.queryIntentActivities(mainIntent, 0);
  midlist := TStringList;
  iter := pkgAppsList.iterator;
  while iter.hasNext do
  begin
    ri := TJResolveInfo.Wrap((iter.next as ILocalObject).GetObjectID);
    mIdList.Add(ri.activityInfo.applicationInfo.packageName);
  end;
  LaunchIntent := PM.getLaunchIntentForPackage(mIdList[2]);
  SharedActivityContext.startActivity( LaunchIntent )
end;