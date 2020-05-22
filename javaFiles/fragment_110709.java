public class MyComponent extends JComponent{
    // etc
    Function<Graphics2D, Void> secondaryPaint;
    public MyComponent(Function<Graphics2D, Void> myfc){
        secondaryPaint = myfc;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        //g2.drawSomething(); // etc

        // Once it is done, check if that function is exists, and call it.
        if(secondaryPaint != null){
            secondaryPaint.apply(g2);
        }
    }

    static class Something {
        public static Void compute(Graphics2D g){
            return null;
        }

        public Void computeNotStatic(Graphics2D g){
            return null;
        }
    }

    public static void main(String[] args) {
        Something smth = new Something();
        new MyComponent(Something::compute); // with static
        new MyComponent(smth::computeNotStatic); // with non-static
    }
}