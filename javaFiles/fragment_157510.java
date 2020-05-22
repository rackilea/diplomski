public class MyClass {
    private JTable particularTable;

    public Myclass (JTable particularTable) {
        this.particularTable = particularTable;
    }

    private void useParticularTable() {
        particularTable.doSomething();
    }
}