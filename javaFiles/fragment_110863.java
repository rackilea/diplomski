public class MainP {

    public static void main(String[] args) {
        Customer c1 = new Customer("c1", 5, true);

        System.out.println(c1.getName() + " " + c1.isChild() + " " + c1.isStudent());

        Customer c2 = new Customer("c2", 50, false);

        System.out.println(c2.getName() + " " + c2.isChild() + " " + c2.isStudent());

    }

}