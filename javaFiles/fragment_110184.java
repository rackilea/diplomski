@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      HashMap<String,String> clickedItem = parent.getItemAtPosition(position);
      String packageName = clickedItem.get("package");

        try{
        PackageManager packManager = getContext().getPackageManager();
        ApplicationInfo app = getContext().getPackageManager().getApplicationInfo(packageName , 0);
        String appName = packManager.getApplicationLabel(app).toString();
 AppData appData = (AppData) getActivity().getApplicationContext();
            appData.setPackageInfo(packageInfo); 
    }
    catch(Exception e){
        e.printStackTrace();
    }




    try {
        Intent appInfo = new Intent(getActivity().getApplicationContext(), permdisabled.class);
        startActivity(appInfo);
    }

    catch (Exception e)
    {
        Log.e(TAG, "error in intent");
    }
}