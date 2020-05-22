//check permission is granted or no    
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) 
     {
      requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, RESULT);
     } 
    else
     {
    //your code
     }