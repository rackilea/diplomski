File imageFile = new File(imagePath);

            ExifInterface exif = new ExifInterface(imageFile.getAbsolutePath());
                            int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

            boolean isVertical = true ; 

            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_270:
                    isVertical = false ; 
                    break;
                case ExifInterface.ORIENTATION_ROTATE_90:
                    isVertical =false ; 
                    break;
            }