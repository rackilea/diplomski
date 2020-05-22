File SDCardRoot = new File(Environment.getExternalStorageDirectory().toString() + "/alQuranData/Reader1/Surah");
                Toast.makeText(getApplicationContext(), SDCardRoot.toString(), Toast.LENGTH_LONG).show();
                if (!SDCardRoot.exists()) {
                    Log.d("DIRECTORY CHECK", "Directory doesnt exist creating directory");
                    SDCardRoot.mkdirs();
                }