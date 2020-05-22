public class Test {
    public static void main(String[] args) {
        Etudiant e1=new  Etudiant(5, "A");
        Etudiant e2=new  Etudiant(6, "B");

        Map<Integer, Etudiant> map= new HashMap<>();
        map.put(1, e1);
        map.put(2, e2);
        System.out.println("map:  " + map);

        Map<Integer, Etudiant> map2= new HashMap<>();
        map2.put(1,map.get(1));
        map2.put(1,map.get(2));
        System.out.println("map2: " + map2);

        changeMe(map2);
        System.out.println("map:  " + map);
        System.out.println("map2: " + map2);
        System.out.println(map.get(1));

        Map<Integer, Etudiant> map3= new HashMap<>();
        map3.putAll(map);
        System.out.println("map3: " + map3);

        changeMe(map3);
        System.out.println("map:  " + map);
        System.out.println("map2: " + map2);
        System.out.println("map3: " + map3);
        System.out.println(map.get(1));
    }
    private static void changeMe(Map<Integer, Etudiant> etudiants) {
        System.out.print("Renamed " + etudiants.get(1));
        etudiants.get(1).name="K";
        System.out.println(" to " + etudiants.get(1));
    }
}
class Etudiant {
    int id;
    String name;
    Etudiant(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Etudiant(" + this.id + ", \"" + this.name + "\")";
    }
}