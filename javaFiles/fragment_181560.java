CustomGallery item = new CustomGallery();

                int dataColumnIndex = imagecursor
                        .getColumnIndex(MediaStore.Images.Media.DATA);

                item.sdcardPath = imagecursor.getString(dataColumnIndex);
                File temp = new File( item.sdcardPath );
                if( temp.exists() )
                     galleryList.add(item);