public void copyXMLFromAssets()
    {
        AssetManager assetManager = mActivity.getAssets();
        File AppDirectory = new File(Environment.getExternalStorageDirectory() + "/" + dirName);
        if (!AppDirectory.exists())
            {
                AppDirectory.mkdirs();
            }
                InputStream in = null;
                OutputStream out = null;
                try
                    {
                        in = assetManager.open(XML_name);
                        File outFile = new File(AppDirectory +"/"+XML_name);                                
                        out = new FileOutputStream(outFile);
                        copyFile(in, out);
                        in.close();
                        in = null;
                        out.flush();
                        out.close();
                        out = null;
                    }
                catch (IOException e)
                    {
                        Log.e("tag", "Failed to copy asset file: " + XML_name, e);
                    }

    }