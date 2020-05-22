// Setting OK Button
    alertDialog.setButton("OK", new DialogInterface.OnClickListener()
    {
        public void onClick(DialogInterface dialog, int which) {

    if(Success)
    {               
        // Progress to the activity
        context.startActivity( new Intent(context, Menu.class) );               
        context.getActivity().finish();
    }
    else
    {
        // Don't do anything
    } 
    });