while (inputStream.hasNextLIne()){
     String line = inputStream.nextLine();
     String tokens = line.split("\\s+");

     String givenName = tokens[0];

     int[] numList = new int[tokens.lenth - 1];

     for (int i = 1; i < tokens.length; i++){
         numList[i - 1] = Integer.parseInt(tokens[i].trim());
     }

     list.add(new Name(givenName, numList);
}