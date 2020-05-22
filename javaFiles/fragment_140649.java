Intent intent = new Intent(Intent.ACTION_MAIN);
    //intent.putExtra("plain_text", "Testing");
    intent.setClassName("packagename", "packagename.ClassName"); // Explicit Intent
    try {
        startActivity(intent);
    }
    catch (Exception e)
    {
        Log.d(TAG","onCreate",e);
    }
}