public static void showAlert(Activity act,String msg)
        {
            AlertDialog.Builder alert = new AlertDialog.Builder(act);
            alert.setMessage(msg).setPositiveButton("OK", new OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which)
                {   
                }
            }).show();
        }