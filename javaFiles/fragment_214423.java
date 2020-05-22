private void showDialog()
    {
        new AlertDialog.Builder(ImagePagerActivity.this,R.style.MyAlertDialogStyle)
                .setTitle("Select your option")
                .setPositiveButton("Save",
                        new DialogInterface.OnClickListener() {
                            public void onClick(
                                    DialogInterface dialog,
                                    int which) {
                                imgView.buildDrawingCache();
                                Bitmap bm = imgView
                                        .getDrawingCache();
                                OutputStream fOut = null;
                                try {
                                    File root = new File(
                                            Environment
                                                    .getExternalStorageDirectory()
                                                    + File.separator
                                                    + "Beauty"
                                                    + File.separator);
                                    if (!root.exists())
                                        root.mkdirs();
                                    File sdImageMainDirectory = new File(
                                            root,
                                            System.currentTimeMillis()
                                                    + ".jpg");
                                    fOut = new FileOutputStream(
                                            sdImageMainDirectory);
                                    bm.compress(
                                            Bitmap.CompressFormat.PNG,
                                            100, fOut);
                                    fOut.flush();
                                    fOut.close();
                                    Toast.makeText(
                                            ImagePagerActivity.this,
                                            "File saved at  Beauty  folder",
                                            Toast.LENGTH_SHORT)
                                            .show();
                                } catch (Exception e) {
                                    Toast.makeText(
                                            ImagePagerActivity.this,
                                            "Error occured. Please try again later.",
                                            Toast.LENGTH_SHORT)
                                            .show();
                                    e.printStackTrace();
                                }
                            }
                        })
                .setNegativeButton("Share",
                        new DialogInterface.OnClickListener() {
                            public void onClick(
                                    DialogInterface dialog,
                                    int which) {
                                try {
                                    imgView.buildDrawingCache();
                                    Bitmap bm = imgView
                                            .getDrawingCache();
                                    OutputStream fOut = null;

                                    File root = new File(
                                            Environment
                                                    .getExternalStorageDirectory()
                                                    + File.separator
                                                    + " Beauty"
                                                    + File.separator);
                                    if (!root.exists())
                                        root.mkdirs();
                                    File sdImageMainDirectory = new File(
                                            root, "1.jpg");
                                    fOut = new FileOutputStream(
                                            sdImageMainDirectory);
                                    bm.compress(
                                            Bitmap.CompressFormat.PNG,
                                            100, fOut);
                                    fOut.flush();
                                    fOut.close();

                                    Intent shareIntent = new Intent(
                                            Intent.ACTION_SEND);
                                    Uri phototUri = Uri
                                            .fromFile(sdImageMainDirectory);
                                    shareIntent.setData(phototUri);
                                    shareIntent
                                            .setType("image/png");
                                    shareIntent.putExtra(
                                            Intent.EXTRA_STREAM,
                                            phototUri);
                                    startActivityForResult(Intent
                                                    .createChooser(
                                                            shareIntent,
                                                            "share using"),
                                            2);

                                } catch (Exception ce) {
                                    ce.printStackTrace();
                                }

                            }
                        })

                .show();
    }