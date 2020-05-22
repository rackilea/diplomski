public class ProductExample {

    public static void main(String[] args) {
        ComputerOrder c = new ComputerOrder();
        c.add(new ComputerPart());
        c.add(new Peripheral());
        //c.add(new Cheese()); // Not allowed
        //c.add(new Fruit()); // Not allowed
        c.add(new Service());

        PartyTrayOrder p = new PartyTrayOrder();
        //p.add(new ComputerPart());  // Not allowed
        //p.add(new Peripheral());  // Not allowed
        p.add(new Cheese());
        p.add(new Fruit());
        p.add(new Service());

    }
}