private static class Content {
    private Guests content;
}

private static class Guests  {
    private List<Guest> guests = new ArrayList<>();

    @JsonAnySetter
    private void addGuest(String name, Guest value) {
        guests.add(value);
    }
}

private static class Guest {
    private Name name;
    private boolean vip;
}

private static class Name {
    private String firstName;
    private String lastName;
}