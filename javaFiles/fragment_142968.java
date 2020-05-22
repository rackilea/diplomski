public static void downloadImage(String fileName, ImageView image, Context context){

    File downloadFolder = Environment.getExternalStorageDirectory();
    File dir = new File(downloadFolder+ "/PopularMovie/");
    Uri downloadPath = Uri.fromFile(new File(dir, "/" + fileName + ".png/"));

    if (downloadPath.toString() != null){
        Picasso.with(context).load(downloadPath).placeholder(R.drawable.placeholder_image).into(image);

    } else {
        Toast.makeText(context, "There is no image of this name saved",
                Toast.LENGTH_LONG).show();
    }
}