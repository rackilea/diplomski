public class Zeitpunkt implements Comparable<Zeitpunkt> {
    private int jahr;
    private int monat;
    private int tag;
    private int stunden;
    private int minuten;
    private double sekunden;

    public int vergleich(Zeitpunkt a) {
        return 0;
    }

    @Override
    public int compareTo(Zeitpunkt o) {
        return vergleich(o);
    }
}