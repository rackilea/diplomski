@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds appModels to the action bar if it is present.
    this.menu = menu;
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();

    switch (id) {
        case R.id.share:

            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBodyText = "Check it out. Your message goes here";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Subject here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
            startActivity(Intent.createChooser(sharingIntent, "Shearing Option"));
            return true;

        case R.id.id_rateus:
            try {
                    startActivity(new Intent(Intent.ACTION_VIEW,                                
android.net.Uri.parse("market://play.google.com/store/apps/details?id=com.slsindupotha&hl=en")));
                }catch (android.content.ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            android.net.Uri.parse("https://play.google.com/store/apps/details?id=com.slsindupotha&hl=en")));
                }

            return true;
    }

    return super.onOptionsItemSelected(item);
}