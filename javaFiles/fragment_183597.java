String file_path = Environment.getExternalStorageDirectory().getAbsolutePath() + 
                            "/PhysicsSketchpad";
    File dir = new File(file_path);
if(!dir.exists)
    dir.mkdirs();
    File file = new File(dir, "sketchpad" + pad.t_id + ".png");
    FileOutputStream fOut = new FileOutputStream(file);

    bmp.compress(Bitmap.CompressFormat.PNG, 85, fOut);
    fOut.flush();
    fOut.close();