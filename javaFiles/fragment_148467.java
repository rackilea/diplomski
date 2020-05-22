String str;
  char[] getArray;

  FileReader fr = new FileReader("/sampleProject");
  BufferedReader br = new BufferedReader(fr);

  br.readLine();
  ArrayList<String> result = new ArrayList<>();

  while ((str = br.readLine()) != null) {
     String[] array = str.split("},");
     for(int i = 0; i< array.length;i++) {
         result.add(array[i]);
     }
  }

  System.out.println("Here it is" + str);

  br.close();