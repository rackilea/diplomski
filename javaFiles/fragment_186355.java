Intent shareIntent = new Intent(Intent.ACTION_SEND);
shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
shareIntent.setType("image/*");

// For a file in shared storage.  For data in private storage, use a ContentProvider.
Uri uri = Uri.fromFile(getFileStreamPath(pathToImage));
shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
startActivity(shareIntent)