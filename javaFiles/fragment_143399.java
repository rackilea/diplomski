public void shareInWhatsapp(String text){
    Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
    whatsappIntent.setType("text/plain");
    whatsappIntent.setPackage("com.whatsapp");
    whatsappIntent.putExtra(Intent.EXTRA_TEXT, text);
    try {
        activity.startActivity(whatsappIntent);
    } catch (android.content.ActivityNotFoundException ex) {
        //whatsapp not installed
    }

}