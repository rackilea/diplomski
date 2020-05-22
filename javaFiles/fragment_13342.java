public String[] setLable() {
      String file_name = "path";
      String[] names = null;
      try {
        ReadFile file = new ReadFile(file_name);
        String[] aryLines = file.OpenFile();
        String[] links = new String[aryLines.length];
        names = new String[aryLines.length];

        int i;
        for(i=2; i < aryLines.length; i++) {
            //System.out.println(aryLines[i]);
            int firstquote = aryLines[i].indexOf("\"")+1;
            int secondquote = aryLines[i].indexOf("\"", firstquote+1);
            int thirdquote = aryLines[i].indexOf("\"", secondquote+1)+1;
            int fourthquote = aryLines[i].indexOf("\"", thirdquote+1);
            names[i] = aryLines[i].substring(firstquote, secondquote);
            links[i] = aryLines[i].substring(thirdquote, fourthquote);
        }
       }catch (IOException e) {
        System.out.println( e.getMessage() );
       }
       return names;
    }