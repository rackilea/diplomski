public class Roughwork {

    public int classVar = 25;

    public void getValue(int a){
        classVar = a;
        System.out.println(classVar);

    }

    public static void main(String[] args) {
        Roughwork test = new Roughwork();
        System.out.println(test.classVar);
        test.getValue(30);
        Roughwork test2 = new Roughwork();
        System.out.println(test2.classVar);
    }

}