public abstract class Fruit  
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append( "Color: " + color.toString() );

        String result = seasonal ? "yes" : "no";
        builder.append("\nSeasonal: " + result);

        return builder.toString();
    }
}