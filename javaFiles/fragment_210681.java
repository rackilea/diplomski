String uri = String.format(Locale.ENGLISH, "geo:%f,%f?q=%f,%f",
                    latitude,
                    longitude,
                    latitude,
                    longitude);
Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
startActivity(intent);