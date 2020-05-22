//Use two seperate lists, one for maintaining numbers and other for text
      ArrayList<String> textIds = new ArrayList<>();
        ArrayList<Integer> numberIds = new ArrayList<>();
        String line = "";
        while((line = br.readLine()) != null) {
          String[] values = line.split(" ");

          if(values.length == 1) {
            String idAsString = values[0];

            try {
               //Parse the value. If successful, it means it was a number. Add to integer array.
               int id = Integer.parseInt(idAsString);
               numberIds.add(id);
            }catch (NumberFormatException e){

              //If not successful, it means it was a string.
               textIds.add(idAsString);
            }
          }
        }
         //In the end sort both the list
        Collections.sort(textIds);
        Collections.synchronizedList(numberIds);

 for(int i = 0; i < textIds.size(); i++){
                String stu = textIds.get(i);
                bw.write(stu);
                bw.newLine();
            }

             for(int i = 0; i < numberIds.size(); i++){
                int numValues = numberIds.get(i);
                bw.write(numValues+"");
                bw.newLine();
            }

            br.close();
            bw.close();