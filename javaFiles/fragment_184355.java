class Main {

    public static void main(String[] args) {
        try (SubResource s = new MyResource().getSubResource()) {
            System.out.println("Before closing");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("After closing");
    }
}