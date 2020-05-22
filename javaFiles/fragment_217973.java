public class MainJava {
    private int state;
    private String title;

    public static void main(String... args) {
        MainJava mj = new MainJava();
        mj.setState(42);
        mj.setTitle("My Title");
    }

    public void setState(int state) {
        doInTransaction(() -> this.state = state);
    }
    public void setTitle(String title) {
        doInTransaction(() -> this.title = title);
    }

    private void doInTransaction(Runnable runnable) {
        preSet();
        runnable.run();
        postSet();
    }

    private void preSet() {
        System.out.println("preset");
    }
    private void postSet() {
        System.out.println("post-set");
    }
}