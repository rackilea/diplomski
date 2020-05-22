import java.util.*;

class Satellite {
}

class Test {
    public static void main(String[] args) {
        List<Satellite> sats = new ArrayList<Satellite>();
        List<Satellite> sats2 = new ArrayList<Satellite>();

        Satellite sat1 = new Satellite();
        Satellite sat2 = new Satellite();

        sats.add(sat1);

        sats2.add(sat1);
        sats2.add(sat2);

        System.out.println(sats.containsAll(sats2));
    }
}