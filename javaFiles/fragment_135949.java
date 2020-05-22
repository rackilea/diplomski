public int getSeats(){
    int theatre = 0;
    int userFilmSelection = MainActivity.filmSelectionNumber;

    theatre = theatres.get(userFilmSelection).getSeatsAvailable();
    Basket.theatre+=theatres.get(userFilmSelection).getTheatreName();

    return theatre;
}