final int MyVersion = Build.VERSION.SDK_INT;

if (MyVersion > Build.VERSION_CODES.LOLLIPOP_MR1) {
       if (!checkIfAlreadyhavePermission()) {
           ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
       } else {
           vfp = getFile();
       }
 }