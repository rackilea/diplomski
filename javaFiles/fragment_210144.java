final Dialog dialog = new Dialog(context);
dialog.setContentView(R.layout.dialog_layout);
TextView error=(TextView)dialog.findViewById(R.id.error);
Button errorButton=(Button)dialog.findViewById(R.id.moreDetailsButton);
Button okButton=(Button)dialog.findViewById(R.id.ok);


//Do whatever you want with the rest of the dialog
// initialize all the onclick listeners a usual


errorButton.setOnClickListener(new View.onClickListener(){

    @Override
    public void onClick(View v){
        TextView errorDetails=(TextView)dialog.findViewById(R.id.moreDetailsView);
        errorDetails.setText(detailedErrorMessage)  //add the details to this text view;
        errorDetails.setVisibility(View.VISIBLE);
        }    
});

dialog.show();