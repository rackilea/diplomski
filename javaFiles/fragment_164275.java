button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
             Uri uri = Uri.parse("http://maps.google.com/maps");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            startActivity(intent)
            }
        });