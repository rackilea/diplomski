String name = "Eve";
for(Map.Entry<String, Person> e : p1.tree()) {
    if(e.getValue().getId().equals(name)) {
        System.out.println(e.getKey());
        break;
    }
}