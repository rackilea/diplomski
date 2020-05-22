class Program {
    private String title, name;
    @SerializedName("desc") private String description;

    private String getTitle() {
        return title == null ? name : title;
    }

    // other getters, empty constructor and so on...
}