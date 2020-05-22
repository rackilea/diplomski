final Button btn1 = (Button) findViewById(R.id.btn1);
final Button btn2 = (Button )findViewById(R.id.btn2);

//Inside onCreate() or similar
btn1.setOnClickListener(new View.OnClickListener() {       
    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.test.com"));

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  //Required to start a new activity
        startActivity(intent);

        btn1.setVisibility(View.GONE);

    }
});

//In the same place
btn2.setOnClickListener(new View.OnClickListener() {       
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_SEND); 
        String[] tos = { "info@email.com" }; 
        intent.putExtra(Intent.EXTRA_EMAIL, tos); 
        intent.putExtra(Intent.EXTRA_TEXT, "body"); 
        intent.putExtra(Intent.EXTRA_SUBJECT, "subject"); 
        intent.setType("message/rfc882"); 
        Intent.createChooser(intent, "Choose Email");
        btn2.setVisibility(View.VISIBLE);
    }
});

//Later, in your other functional code
switch (realViewSwitcher.getCurrentScreen()) {
    case 0:
        //do your stuff
        break;
    case 2:
        //other stuff
        break;
    default: //If you need it
        throw new Exception("Oops...");
}