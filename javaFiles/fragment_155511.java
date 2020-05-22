public class Printer {
    private final String toPrint;

    public Printer(String toPrint) {
        this.toPrint = toPrint;
    }

    public void print() {
        System.out.println(toPrint);
    }
}


List<Printer> list = new ArrayList<>();
list.add(new Printer("1"));
list.add(new Printer("2"));
list.add(new Printer("3"));

for (Printer p : list) {
    p.print();
}