public class Tre {
    private ArrayList<String> open;

    public Tre() {
        open = new ArrayList<String>();//just initialize ArrayList
    }

    public void loadData() {//add a new method to load ArrayList
        String s = "chaine1,chaine2, chaine a, chaine b, chaine c";
        String str[] = s.split(",");

        for (int i = 0; i < str.length; i++) {
            open.add(str[i]);
        }
    }

    public void nouvel() {
        System.out.println(open.get(0));
        int test = open.indexOf(" chaine b");
    }
}