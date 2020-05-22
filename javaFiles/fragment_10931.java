File file = ImageStorage.checkifImageExists(ImageStorage.getImageName(list.get(position).imageUrl));
        if (file != null) {

            // this step skips
            //File file = ImageStorage.getImage("/" + ImageStorage.getImageName(list.get(position).imageUrl));
            // and this one also skips
            //String path = file.getAbsolutePath();
            Picasso.with(context)
                    .load(file) // why creating new file if you already have same file.
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .into(holder.menuImage);

        } else {
            new ImageDownloaderTask(list.get(position).imageUrl, holder.menuImage, ImageStorage.getImageName(list.get(position).imageUrl)).execute();
        }