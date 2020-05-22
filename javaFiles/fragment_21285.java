@GetMapping("/create")
public void create() {
    Actor actor1 = new Actor("Pedro", "Perez", "40");
    Actor actor2 = new Actor("Alfredo", "Mora", "25");
    Actor actor3 = new Actor("Juan", "Martinez", "20");
    Actor actor4 = new Actor("Mario", "Arenas", "30");

    List<Actor> actorList = new ArrayList<>();
    actorList.add(actor1);
    actorList.add(actor2);
    actorList.add(actor3);
    actorList.add(actor4);

    Movie movie = new Movie("Titanic", "Drama", "1984", actorList);

    movieService.create(movie);
}