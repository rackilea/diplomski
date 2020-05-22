public class Test {
    public static void main(String[] args) {
        Set<Animal> set1 = new HashSet<>(Arrays.asList(new Animal("Jaguar", "Panthera"),
                                                       new Animal("Margay", "Leopardus"),
                                                       new Animal("Tiger", "Panthera")));
        Set<Animal> set2 = new HashSet<>(Arrays.asList(new Animal("Bobcat", "Lynx"),
                                                       new Animal("Cougar", "Puma"),
                                                       new Animal("Leopard", "Panthera")));
        TreeSet<Animal> treeSet1 = new TreeSet<>(new GenusComparator());
        treeSet1.addAll(set1);
        TreeSet<Animal> treeSet2 = new TreeSet<>(new GenusComparator());
        treeSet2.addAll(set2);
        treeSet1.retainAll(treeSet2);
        System.out.println(treeSet1);
    }
}
class Animal {
    public String species;
    public String genus;

    public Animal(String species, String genus) {
        this.species = species;
        this.genus = genus;
    }
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Animal && this.species.equals(((Animal)obj).species);
    }
    @Override
    public int hashCode() {
        return this.species.hashCode();
    }
    @Override
    public String toString() {
        return this.species + "/" + this.genus;
    }
}
class GenusComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal animal1, Animal animal2) {
        return String.CASE_INSENSITIVE_ORDER.compare(animal1.genus, animal2.genus);
    }
}