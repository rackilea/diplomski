AlertDialog dialog = new AlertDialog.Builder(MapsActivity.context).create();
           dialog.setTitle("Confirmation");
           dialog.setMessage("Confirm this location as end point ?");

     dialog.setButton(DialogInterface.BUTTON_POSITIVE,"Yes", new DialogInterface.OnClickListener() {
         public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub

     Intent intent = new Intent(MapsActivity.context, GetDestination.class);
                        //you must put your map activity    
                            MapsActivity.context.startActivity(intent);


                        }   
                    });


              dialog.show();