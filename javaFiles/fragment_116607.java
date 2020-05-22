BufferedReader bfr=new BufferedReader(new InputStreamReader(hdfs.open(path)));     //open file first
            String str = null;
            BufferedWriter br=new BufferedWriter(new OutputStreamWriter(hdfs.create(path,true))); 
            while ((str = bfr.readLine())!= null)
            {
                br.write(str); // write file content
                br.newLine();
               System.out.println("   ->>>>>  "+str);
             }
            br.write("Hello     ");  // append into file
            br.newLine();
            br.close(); // close it