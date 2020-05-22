public class Generalization {
    private List<Generalization> superClasses;
    private List<Generalization> subClasses;

    public Generalization(){
        superClasses = new ArrayList<Generalization>();
        subClasses = new ArrayList<Generalization>();
    }

    public boolean isRoot() {
        return superClasses.size() == 0;
    }

    public boolean isLeaf() {
        return subClasses.size() == 0;
    }

    // path length to root
    public String getDIT() {
        return Integer.toString(recuDIT(this));
    }

    public int recuDIT(Generalization g) {
        if (g.isRoot())
            return 0;
        else {
            int maxLength = 0;
            for(int i = 0 ; i < g.superClasses.size(); i++){
                maxLength = Math.max(maxLength, recuDIT(g.superClasses.get(i)));
            }
            return maxLength + 1;
        }
    }

    // path length to leaf
    public String getCLD() {
        return Integer.toString(recuCLD(this));
    }

    public int recuCLD(Generalization g) {
        if (g.isLeaf())
            return 0;
        else {
            int maxLength = 0;
            for(int i = 0 ; i < g.subClasses.size(); i++){
            maxLength = Math.max(maxLength, recuCLD(g.subClasses.get(i)));
            }
            return maxLength + 1;
        }
    }

public static void main(String[] args){
    Generalization root = new Generalization();

    Generalization ch1 = new Generalization();
    Generalization ch2 = new Generalization();

    root.subClasses.add(ch1);
    root.subClasses.add(ch2);

    Generalization gc1 = new Generalization();
    Generalization gc2 = new Generalization();
    Generalization gc3 = new Generalization();

    ch2.superClasses.add(root); 
    ch2.subClasses.add(gc1);
    ch2.subClasses.add(gc2);

    ch1.subClasses.add(gc3);
    ch1.superClasses.add(root);

    Generalization ggc1 = new Generalization();

    gc3.subClasses.add(ggc1);
    gc3.superClasses.add(ch1);

    gc2.superClasses.add(ch2);
    gc1.superClasses.add(ch2);

    ggc1.superClasses.add(gc3);

    System.out.println(ggc1.getDIT());
    System.out.println(root.getCLD());



}
}