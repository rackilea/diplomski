public static void main(String[] args) {
    // The class you created is Movies not Movie (IDK if that was typo)
    ArrayList<Movies> list = new ArrayList<Movies>();
    list.add(new Movies("Force Awakens", 8.3, 2015));
    list.add(new Movies("Star Wars", 8.7, 1977));
    list.add(new Movies("Empire Strikes Back", 8.8, 1980));
    list.add(new Movies("Return of the Jedi", 8.4, 1983));

    Collections.sort(list);

    System.out.println("Movies after sorting : ");
    for (Movies movie : list) {
       System.out.println(movie.getName() + " " + movie.getRating() + " " + 
       movie.getYear());
    }
}