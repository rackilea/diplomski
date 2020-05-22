@Override
public boolean onCreateOptionsMenu(Menu menu) {
    com.actionbarsherlock.view.MenuInflater inflater = getSupportMenuInflater();
    inflater.inflate(R.menu.menu, menu);

    // Locate MenuItem with ShareActionProvider
    MenuItem item = menu.findItem(R.id.menu_share);
    ShareActionProvider shareActionProvider = (ShareActionProvider) item.getActionProvider(); //line 387

    Intent shareIntent = new Intent(Intent.ACTION_SEND);
    shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
    shareIntent.setType("text/plain");

    shareIntent.putExtra(Intent.EXTRA_TEXT, "Test");
    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Test");

    shareActionProvider.setShareIntent(shareIntent);

    return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {

    switch (item.getItemId()) {

    case android.R.id.home:
        onBackPressed();
        break;

    case R.id.menu_share:
        // EXAMPLE OF WHAT YOU CAN DO
        //          Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        //          sharingIntent.setType("image/png");
        //          sharingIntent.putExtra(android.content.Intent.EXTRA_STREAM, Uri.fromFile(f));
        //          //sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        //          //sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Body");
        //          startActivity(Intent.createChooser(sharingIntent, "Share via"));

        break;

    default:
        break;

    }
    return super.onOptionsItemSelected(item);
}