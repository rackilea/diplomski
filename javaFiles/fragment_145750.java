{

                File f1 = new  File(outfile);
                if (f1.exists()) {
                // kill
                f1.delete();
                // create it then!
                f1.createNewFile();
                }

                FileWriter writer= new FileWriter(f1);
                BufferedWriter b= new BufferedWriter(writer);

                b.write(p.toString());
                b.newLine();
                b.close();


        }