Intent shareIntent = new Intent(Intent.ACTION_SEND);
Uri phototUri = Uri.parse(path);
shareIntent.setData(photootUri);
shareIntent.setType("image/png");
shareIntent.putExtra(Intent.EXTRA_STREAM, photootUri);
getContext().startActivity(Intent.createChooser(shareIntent, "Use this for sharing"));