public static void addRating(int rating) {
    if (rating >= 1 && rating <= 5) {
        numberOfPeopleRated++;
        totalMovieRating += rating;
        System.out.println("You rated " + movieName + " a " + rating);
    } else {
        System.out.println("Wrong rating");
    }
}

public static void getAverage() {
    double averageRating = ((double)totalMovieRating) / numberOfPeopleRated;
    System.out.println("The average Rating is " + averageRating);
}