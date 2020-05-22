Toast.makeText(context, "Calling shutdown", Toast.LENGTH_SHORT).show();

    if (MainActivity.getInstance() != null) {
        MainActivity.getInstance().methodToCall();
    } 
    else {
        Intent i = new Intent(context, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra("CALL_METHOD", true);
        context.startActivity(i);
    }