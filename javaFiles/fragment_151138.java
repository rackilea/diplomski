InputStreamReader is;
        FileInputStream fs;
         try{
                File file=open.getSelectedFile();   
                fs=new FileInputStream(file);
                is=new InputStreamReader(fs,"UTF-8");
                br=new BufferedReader(is);
                StringBuffer content=new StringBuffer("");
                String line="";
                while((line=br.readLine())!=null){
                   content.append(line+"\n");
                 }
                br.close();
                getEditorPane().setText(content.toString());
          }
          catch(Exception e){

          }