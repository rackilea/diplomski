public static class ImmutableListService {

    public void handle(Message<ImmutableList<String>> data) {
        System.out.println("!!!!" + data);
    }

}