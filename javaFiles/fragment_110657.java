String totalString;
BufferedReader in;
try {
     in = new BufferedReader(new InputStreamReader(openFileInput(filename)));
     totalString = in.readLine();
     in.close();
     System.out.println("Read File Successfully");
     System.out.println(totalString);
    }
catch (Exception e) {
     e.printStackTrace();
     System.out.println("Error in Reading File.");
    }