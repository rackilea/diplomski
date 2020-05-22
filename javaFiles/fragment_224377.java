floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetWallpaper sw = new SetWallpaper();
                sw.execute(imageUrls[indexOfImage])
            }
        });