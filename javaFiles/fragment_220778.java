private void shareLocation(){
    link = formatLocation(getLocation(), getResources().getStringArray(R.array.link_templates)[0]);
    Intent intent = new Intent();
    intent.setAction(Intent.ACTION_SEND);
    intent.putExtra(Intent.EXTRA_TEXT, link);
    intent.setType("text/plain");
    startActivity(Intent.createChooser(intent, getString(R.string.share_location_via)));
}