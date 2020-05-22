Bitmap temp = BitmapFactory.decodeFile(PATH_TO_PHOTO, o);

_mPhoto = Bitmap.createScaledBitmap(
                            temp,
                            _mPhoto.getWidth() / scale, _mPhoto.getHeight()
                                    / scale, false);

temp.recycle(); //this call is the key ;)