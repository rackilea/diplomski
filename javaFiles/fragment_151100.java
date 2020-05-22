public void refreshExcelData() throws IOException {

Runtime.getRuntime().exec(new String[] {
      "C:\\Windows\\System32\\wscript.exe",
       System.getProperty("user.dir")+"\\requiredSource\\myVBS.vbs"‌
   });
}