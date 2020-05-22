@SortingFields(fields = {"id", "name"})
class MovieDTO implements Comparable<MovieDTO> {

    @FieldExtractor(getterName = "getIdentifier")
    private Long id;
    private String name;

    public Long getIdentifier() {
        return id;
    }

    public String getName() {
        return name;
    }

    ...

}