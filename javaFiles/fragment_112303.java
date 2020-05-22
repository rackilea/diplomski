public void showAlert(String message){
AlertDialog.Builder builder = new AlertDialog.Builder(this);
                 builder.setTitle("اطلاعات ریافت شد!");
                 builder.setMessage(message);
                 builder.setPositiveButton("HEY!", new DialogInterface.OnClickListener() 
                 {

                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // TODO Auto-generated method stub

                    }
                });
                 builder.show();
}