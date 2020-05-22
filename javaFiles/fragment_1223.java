........
........
try {
                File root = new File(Environment.getExternalStorageDirectory()
                        .getName() + "/" + fsitem.get(i));
                File namefile = new File(root, ".name");
                if (!namefile.exists()){
                    namefile.createNewFile();
                }
                FileReader namereader = new FileReader(namefile);
                BufferedReader in = new BufferedReader(namereader);
                String[] str_array = new String[4];
........
........