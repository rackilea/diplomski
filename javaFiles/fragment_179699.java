private void showDialog(){
if (openDoorDialog != null && openDoorDialog.isShowing()) {
    openDoorDialog.dismiss();
}

openDoorDialog = new AlertDialog.Builder(this)
        .setTitle(R.string.open_door_title)
        .setCancelable(false)
        .setIconAttribute(android.R.attr.alertDialogIcon)
        .setMessage(R.string.open_door_warning).create();
}

private void hideDialog(){
    if (openDoorDialog != null && openDoorDialog.isShowing()) {
        openDoorDialog.dismiss();
    }
}

private void handleLog(String newLog){
     if(newLog.contains(Const.CLOSED_DOOR_MESSAGE)){
         hideDialog();

     }
     else if(openDoorDialog != null && newLog.contains(Const.OPEN_DOOR_MESSAGE) && openDoorDialog_count==0 /*&& status.getPrinting()*/) {
         showDialog();
     }
}