List<String> csvFiles = new ArrayList<String>();                            
    try {
        File[] files = new File(textCSV.getText()).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                csvFiles.add(file.getName());
            }
        }
        for(int i=0;i<csvFiles.size();i++)
        {
           System.out.println(csvFiles.get(i));             

           String Output = csvFiles.get(i).substring(0, csvFiles.get(i).indexOf(".")) + ".xml" //how to put here csv name
        }
    }