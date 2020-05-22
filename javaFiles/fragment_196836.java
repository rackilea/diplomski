public static void createPojoFromCsvHeader(File csvInputFile,String directoryOfjavaFile,String packageName,String className)
  {    
      try(BufferedReader stream = new BufferedReader(new FileReader(csvInputFile))) {
        String packagePath=packageName.replace(".","/");
        String javaOutputDirPath=directoryOfjavaFile+"/"+packagePath+"/";
        System.out.println("creating directory ->"+javaOutputDirPath);
        File f=new File(javaOutputDirPath);
        if(f.mkdirs()){
            System.out.println("directory :"+javaOutputDirPath+" created succesfully..");
        }else{
            System.out.println("directory :"+javaOutputDirPath+" already exist..");
        }
        String javaOutputFilePath=directoryOfjavaFile+"/"+packagePath+"/"+className+".java";
        File javaOutPutFile=new File(javaOutputFilePath);
        javaOutPutFile.createNewFile();
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(javaOutputFilePath)));          
        System.out.println("generating class..");            
        out.println("package "+packageName+";");
        out.println("public class " + className + " {");
        String line = null;
        String[] fields = null;
        int rowNum = 0;
        while ((line = stream.readLine()) != null) {
            if (line.isEmpty() || line.startsWith("#")) {
                continue;
            } else {
                if (fields == null) {
                    fields = line.split(",");
                }

                rowNum++;
                String[] values = line.split(",");
                for (int i = 0; i < fields.length; i++) {
                    out.println("\t\tprivate String " + fields[i] + " = \""+ StringEscapeUtils.escapeJava(values[i])+ "\";");
                }

                for (int i = 0; i < fields.length; i++) {
                    String tempField=StringEscapeUtils.escapeJava(values[i]).substring(0, 1).toUpperCase()+StringEscapeUtils.escapeJava(values[i]).substring(1);

                    //getter method
                    out.println("");
                    out.println("\t\tpublic String  get"+tempField+ "(){");
                    out.println("\t\t\treturn this."+StringEscapeUtils.escapeJava(values[i])+";");
                    out.println("\t\t}");
                    //setter method
                    out.println("\t\tpublic void  set"+tempField+"(String "+ StringEscapeUtils.escapeJava(values[i])+"){");
                    out.println("\t\t\t this."+StringEscapeUtils.escapeJava(values[i])+" = "+ StringEscapeUtils.escapeJava(values[i])+";");
                    out.println("\t\t}");
                }

                out.println("");
                out.println("// toString() Method");
                out.println("\t\t public String toString(){");
                StringBuffer buffer=new StringBuffer();
                buffer.append("\"{");
                for (int i = 0; i < fields.length; i++) {
                    buffer.append("\\\""+StringEscapeUtils.escapeJava(values[i])+"\\\"=\"+"+StringEscapeUtils.escapeJava(values[i]));
                    if(i < fields.length-1){
                        buffer.append("+\",");
                    }
                    else{
                        buffer.append("+\"");
                    }
                }
                buffer.append("}\";");
                out.println("\t\t\t return "+buffer);
                out.println("\t\t}");
            }
            out.println("}");
            out.close();
        }
        System.out.println("no of lines fetch from csv :"+rowNum);
        }catch(IOException e)
      {
            e.printStackTrace();
      }

  }