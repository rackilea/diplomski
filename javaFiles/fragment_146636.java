@Override
public void onBackPressed() {

    if(this.view.canGoBack()) 
    {
        this.view.goBack();
    } 
    else {
             new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Fermer SByNight")
                .setMessage("Etes-vous sur de vouloir quittez SByNight?")
                .setPositiveButton("Oui", new DialogInterface.OnClickListener()
            {
                 @Override
                 public void onClick(DialogInterface dialog, int which) 
                 {
                    finish();    
                 }

            })
            .setNegativeButton("Non", null)
            .show();
       }
    }
}