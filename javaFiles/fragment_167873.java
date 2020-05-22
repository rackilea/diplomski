private void callMyDialog(){ 
    //Customize the title and message as needed
    String title = "This is my dialog title";
    String mess = "This is my dialog message";
    OkCancelDialogFragment dialog = OkCancelDialogFragment.newInstance(title, mess);
    dialog.show(getFragmentManager(), "OkCancelDialogFragment2");
}