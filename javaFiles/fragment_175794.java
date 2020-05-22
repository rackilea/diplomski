String path = Environment.getExternalStorageDirectory().toString()+"/YOUR folder here/";
            File f = new File(path);        
            final File listfile[] = f.listFiles();      
            String[] fileList = new String[listfile.length];
            for (int i=0; i < listfile.length; i++)     
            {
                fileList[i] =  listfile[i].getName();
                Log.v("Files", "FileName:" + listfile[i].getName());  
            }