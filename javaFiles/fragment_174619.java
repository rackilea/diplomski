public static void main(String[] args) {

  List<StarTrek> cast = Arrays.asList(StarTrek.values());

  Collections.sort(cast, new StarTrekSorter());

  for (StarTrek trek : cast) {
    System.out.println(trek);
  }  
}