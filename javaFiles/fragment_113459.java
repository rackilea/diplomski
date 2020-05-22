import java.util.concurrent.TimeUnit;

public class Play2 {
    public static void main(String[] args) {
        Model2 model2 = new Model2();
        View2 view2 = new View2();
        new Controller2(model2, view2);
        view2.show();
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                // one of the few times it's OK to ignore an exception
            }
            String text = String.format("Counter Value: %d", i);
            model2.setText(text);
        }
    }
}