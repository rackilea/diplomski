public class AutoSearch {

    public Auto oneAuto() {

        String text = getOperations();

        if (text != null) {
            return new Auto(text);
        } else {
            return null;
        }

    }

}