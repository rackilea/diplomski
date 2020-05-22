public class MyNewType {

    public void someMethod(TrafficLight tl, Coin coin) {
        //do something
    }

    public static enum TrafficLight {
        red, amber, green;
    }

    public static enum Coin {
        oneCent(.01f), twoCent(.02f), fiveCent(.05f), tenCent(.1f), fiftyCent(.5f), oneDollar(1f), twoDollar(2f);

        private Coin(float amount) {
            this.amount = amount;
        }
        float amount;

    }

}