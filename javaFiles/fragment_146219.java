String currentRunningApp = TaskChecker.getForegroundApplication(yourContext);

if(currentRunningApp.equals("com.whatsapp")){
ActivityManager am = (ActivityManager)yourContext.getSystemService(Context.ACTIVITY_SERVICE);    

    Intent startMain = new Intent(Intent.ACTION_MAIN); 
    startMain.addCategory(Intent.CATEGORY_HOME); 
    startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
    this.startActivity(startMain);

    am.killBackgroundProcesses(currentRunningApp );
}