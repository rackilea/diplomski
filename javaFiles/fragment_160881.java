try {
        InputStream input = new FileInputStream("qa-textbox.xls");
        POIFSFileSystem fs = new POIFSFileSystem(input);
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFPatriarch pat = sheet.getDrawingPatriarch();
        List children = pat.getChildren();

        Iterator it = children.iterator(); 
        while(it.hasNext()) {           
            HSSFShape shape = (HSSFShape)it.next();
            if (shape instanceof HSSFTextbox){
              HSSFTextbox textbox = (HSSFTextbox)shape;
              HSSFRichTextString richString = textbox.getString();
              String str = richString.getString();
              System.out.println("String: " + str);
              System.out.println("String length: " + str.length());
            }
        }  
    } catch (IOException ex) {
        ex.printStackTrace();
    }