private Category getCategory(String val) {
    Category category = CATEGORIES_BY_STRING.get(val.toLowerCase());
    if (category == null) {
        throw new IllegalArgumentException();
    }
    return category;
}