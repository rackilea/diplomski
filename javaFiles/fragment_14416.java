try {
String ExternalLocation = Environment.getExternalStorageDirectory().getAbsolutePath();
File MakeLogDir = new File(ExternalLocation + "/TESTFolder");
MakeLogDir.mkdirs();
BufferedWriter PersianLog = new BufferedWriter(new FileWriter(ExternalLocation + "/TESTFolder/test1.log",true));
BufferedWriter EnglishLog = new BufferedWriter(new FileWriter(ExternalLocation + "/TESTFolder/test2.log",true));
BufferedReader PersianLogFile = new BufferedReader(new FileReader(ExternalLocation + "/TESTFolder/test1.log"));
BufferedReader EnglishLogFile = new BufferedReader(new FileReader(ExternalLocation + "/TESTFolder/test2.log"));
int PersianLogResults = PersianLogFile.read();
int EnglishLogResults = EnglishLogFile.read();
if (PersianLogResults == -1){
startActivity(new Intent(Splash_Page.this, Main_Page.class));
}else if (EnglishLogResults == -1){
startActivity(new Intent(Splash_Page.this, Main_Page_FA.class));
}
PersianLog.close();
EnglishLog.close();
PersianLogFile.close();
EnglishLogFile.close();
} catch (IOException e) {
}