static private void getContent(Context context, String[] dataMms, Mms unMms) {
        if (dataMms[1].equals("text/plain")) {
            unMms.setCorps(dataMms[2]);
        } else {
            if ("image/jpeg".equals(dataMms[1]) || "image/bmp".equals(dataMms[1]) ||
                    "image/gif".equals(dataMms[1]) || "image/jpg".equals(dataMms[1]) ||
                    "image/png".equals(dataMms[1])) {
                unMms.setTypeContenu(dataMms[1]);
                Uri partURI = Uri.parse("content://mms/part/" + dataMms[4]);
                InputStream is = null;
                Bitmap bitmap = null;
                try {
                    is = context.getContentResolver().openInputStream(partURI);
                    bitmap = BitmapFactory.decodeStream(is);
                } catch (IOException e) {
                    Log.d("Exception", e.toString());
                } finally {
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e) {
                            Log.d("Exception", e.toString());
                        }
                    }
                }
                if (bitmap != null) {
                    File file = new File(context.getApplicationInfo().dataDir + "/files/", dataMms[0]);
                    OutputStream Fout = null;
                    try {
                        file.createNewFile();
                        Fout = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, Fout);
                        Fout.flush();
                        Fout.close();
                    } catch (FileNotFoundException e) {
                        Log.d("Exception", e.toString());
                    } catch (IOException e) {
                        Log.d("Exception", e.toString());
                    }
                }
            }
        }
    }