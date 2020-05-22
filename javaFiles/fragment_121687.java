boolean exists = false;
 File createdir = new File(Environment.getExternalStorageDirectory() + "/easyvoicenotepad");
 File createdir2 = new File(Environment.getRootDirectory().getAbsolutePath() +"/easyvoicenotepad");
    if (createdir.exists()) {       
    exists = true;
    }
    else {
        createdir.mkdir();
    }
    if (createdir2.exists()) {      
    exists = true;
    }
    else {
        createdir.mkdir();
    }