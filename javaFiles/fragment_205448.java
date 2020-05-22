public class WeirdException extends Exception {

    @Override
    public boolean equals (Object obj) {
        return (obj instanceof WeirdException);
    }

}