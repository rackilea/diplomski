public void fillItems(){
    try{
        BufferedReader br = new BufferedReader(new FileReader("/catalog.txt")); 
        String text = null;
        while ((text=br.readLine())!=null){
           String[] itemArray = text.split(","); 
           // you might want to check array size
           items.add(new ItemBean (itemArray[0], itemArray[1], itemArray[2], itemArray[3], itemArray[4]));

        }

        br.close();
    }catch(Exception e){
      e.printStackTrace();
    }
}