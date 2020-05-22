String imageName = String.valueOf(System.currentTimeMillis());
                filename = Environment.getExternalStorageDirectory().getPath() + "/YourFolder/" + imageName + ".jpg";
                imageUri = Uri.fromFile(new File(filename));
                // start default camera
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                cameraIntent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT,
                        imageUri);
                startActivityForResult(cameraIntent, 100);