String fileName = "myImage.jpg";
        String imagePath = Environment.getExternalStorageDirectory() + "/" + fileName;

        File file = new File(imagePath);
        Uri imageUri = Uri.fromFile(file);

        Glide.with(this)
                .load(imageUri)
                        .into(imgView);