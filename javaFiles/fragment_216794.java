// note the static modifiers
public static Predicate<Movie> titleFilter(String filter){
    return m -> m.getTitle().toLowerCase().contains(filter.toLowerCase());
}

public static Predicate<Movie> translationFilter(String filter){
    return m -> m.getTranslation().toLowerCase().contains(filter.toLowerCase());
}