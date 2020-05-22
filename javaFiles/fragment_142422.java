public static void main(String[] args) { 
      ent = new Entity();
      ent.setStart(1);
      ent.setBegin(2);
      int start = 0;
      ent.setStart(start);
      List<String> sentences = new ArrayList<String>(Arrays.asList("I have a thing", "I have nothing"));
      List<String> context = sentences.subList(0,sentences.size() - 1);
      String target = sentences.get(sentences.size() -1 );

}