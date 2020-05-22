List<String[]> arrays = new ArrayList<String[]>(); //You need an array list of arrays since you dont know how many lines does the text file has
try {
        BufferedReader in = new BufferedReader(new FileReader("infilename"));
        String str;
        while ((str = in.readLine()) != null) {
           String arr[] = str.split(" ");
           if(arr.length>0) arrays.add(arr);
        }
        in.close();
    } catch (IOException e) {
    }