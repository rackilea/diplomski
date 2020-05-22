public class PropertyFactory {
    private static IProperty prop;

    public static createProperty(char version) {

        switch (version) {
            case '1':
                prop = new Prop();
                break;  // Don't forget a `break` here.
            case '2':
               prop = new Prop1();
               break;

            default:  // do have a default case
               prop = null;
        } 
        return prop;
    }
}