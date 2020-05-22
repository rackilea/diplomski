class One implements Interface
{
    One(String foo){ }

    public void sayName() {
        System.out.println("One");
    }
}

Map<String, Function<String, Interface>> associations = new HashMap<>();
associations.put("first", One::new);