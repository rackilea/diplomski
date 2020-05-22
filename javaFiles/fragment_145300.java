Intent sendIntent = new Intent(Intent.ACTION_SEND);
  // Always use string resources for UI text.
  // This says something like "Share this photo with"
  String title = getResources().getString(R.string.chooser_title);
  // Create intent to show the chooser dialog
  Intent chooser = Intent.createChooser(sendIntent, title);

  // Verify the original intent will resolve to at least one activity
  if (sendIntent.resolveActivity(getPackageManager()) != null) {
      startActivity(chooser);
  }