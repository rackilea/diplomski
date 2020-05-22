public class Table<C extends Comparable<C>,V> {

    Association<C,V>[] asso;

    public Table(int n) {
        asso = new Association[n];
    }

    public void add(C cle, V valeur) {
        asso[0] = new Association<C,V>(cle,valeur);
        Arrays.sort(asso, (a,b) -> a.cle.compareTo(b.cle));
    }

    public static class Association<C,V> {

        public C cle;
        public V valeur;

        public Association(C cle,V valeur){
            this.cle = cle;
            this.valeur = valeur;
        }
    }
}