mButton.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(final View v) {
    String uri = String.format("geo:%f,%f", latitude, longitude); // for example pass geo:75.333000,30.003030 to search for latitude = 75.333000 and longitude = 30.003030 as your default search query
    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
    startActivity(intent);
        }
    });