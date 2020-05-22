ArrayList<Integer> list = new ArrayList();
while ((line = br.readLine()) != null) {
    Integer userInputAsInteger = Integer.parseInt(line);
    if(userInputAsInteger > num){
      list.add(userInputAsInteger );
}
}