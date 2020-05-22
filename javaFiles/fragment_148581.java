try{
Intent intent = pm.getLaunchIntentForPackage(package_name);
startActivity(intent);
}
catch(Exception anfe)
{
        try{
             startActivity(new Intent(Intent.ACTION_VIEW,    Uri.parse("market://details?id=" + package_name)));
         }
        catch(Exception a){
        {
          startActivity(new Intent(Intent.ACTION_VIEW,    
          Uri.parse("https://play.google.com/store/apps/details?id=" + package_name)));
        }
    }