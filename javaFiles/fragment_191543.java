class Person {
    private String name;
    private int age;
    private List<String> amigos = new ArrayList<>();

    public ArrayList<String> getAmigos () {
        return amigos;
    }

    public void addAmigo(String amigo) {
        amigos.add(amigo);
   }
}