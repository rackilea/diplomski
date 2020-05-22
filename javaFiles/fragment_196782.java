public static void main(String[]args){

  Scanner input = new Scanner(System.in);
  String bubba = input.nextLine();



  Map<Integer,Integer> occurrences = new HashMap<Integer,Integer>(); 

  for(String currentWord: bubba.split(" ")){
      Integer current = occurrences.get(currentWord.length());
      if(current==null){
          current = 0;
      }

      occurrences.put(currentWord.length(), current+1);
  }

  for(Integer currentKey: occurrences.keySet()){
      System.out.println("There are "+occurrences.get(currentKey)+" "+currentKey+" letter words");
  }

}