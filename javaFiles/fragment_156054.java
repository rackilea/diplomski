private Integer getNumberOfFavoriteColumn(ObservableList<Person> persons){
    int maxNumberOfFavorite = 0;
    for(Person person : persons){
        maxNumberOfFavorite = Math.max(maxNumberOfFavorite, person.getNumbers().size());
    }
    return maxNumberOfFavorite;     
}