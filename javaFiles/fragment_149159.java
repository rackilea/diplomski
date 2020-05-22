public void createbtnteam_westernbulldogs()
{
AlertDialog alertDialog = new AlertDialog.Builder(this).create();
alertDialog.setIcon(R.drawable.team_westernbulldogs);
alertDialog.setTitle("What kind of Banner do you Want to Create?");
alertDialog.setButton("Text", new DialogInterface.OnClickListener() {
   public void onClick(DialogInterface dialog, int which) {
       createText();

   }
alertDialog.setIcon(R.drawable.icon);
alertDialog.show();
}     });