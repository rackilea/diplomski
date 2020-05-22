builder.setSingleChoiceItems(adapter,-1, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {  
            String itemName=adapter.getItem(which);
            button.setText(itemName);   
            dialog.dismiss();   
        }
    });