public void callWebService()
{
    if (myProgressDialog != null) myProgressDialog.dismiss();
    myProgressDialog = ProgressDialog.show(OverviewMoney.this,"", "Récupération liste des positions cash",true); 


       final Runnable runInUIThread = new Runnable() {
            public void run() {
             setListView();                
            }
          };

          new Thread() {
                @Override public void run() 
                {
                  loadListMoney();
                  myProgressDialog.dismiss();
                  uiThreadCallback.post(runInUIThread);                     
                  myProgressDialog= null;
                }
              }.start();
}