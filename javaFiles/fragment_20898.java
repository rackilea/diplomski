private String number  = "";

    public class Constant {

          public static void alertDialogShow(Context context,String title,String message,String _number)
                {
this.number = _number;

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle(title);
                    builder.setMessage(message);
                    builder.setCancelable(false);
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
        //to do your stuff
                        }

                    });

                    builder.setNegativeButton("No", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            dialog.cancel();

                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

    public void call(){

        Intent in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + Uri.encode(number)));
        try{
            startActivity(in);
        }catch (ActivityNotFoundException e){
            Toast.makeText(getApplicationContext(), "Your Activity is not Found", Toast.LENGTH_LONG).show();
        }
    }

        }