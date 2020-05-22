try {
    Uri uri = Uri.parse(Imageid[position]);
    Log.d("picasso", uri.toString());
} catch (Exception ex) {
    ex.printStackTrace();
}