public interface Race_Attributes {
    String[] FirstNames = Deserializer.deserializeFirstNames();
 }

final class Deserializer {

    private Deserializer() {}

    public static String[] deserializeFirstNames() {
        try(ObjectInputStream in = new ObjectInputStream(
            new FileInputStream(
                "./res/binary_files/Human_FirstNameString[].ser"))) {
            return (String[]) in.readObject();
        }
        catch( IOException | ClassNotFoundException e) {
            return new String[0];
        }
    }
}