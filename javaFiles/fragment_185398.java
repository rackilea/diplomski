if(android.os.Build.VERSION.SDK_INT >= 29){
       Intent intent = new Intent(Intent.ACTION_INSTALL_PACKAGE);
       intent.setData(Uri.fromFile(outputFile));
       intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
       startActivity(intent);   
}else{
      Intent intent = new Intent(Intent.ACTION_VIEW);
      //output file is the apk downloaded earlier
      intent.setDataAndType(Uri.fromFile(outputFile), "application/vnd.android.package- 
      archive");
      startActivity(intent);
}