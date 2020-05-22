public static void main(final String[] args) throws ParseException {
            NumberFormat formatter = NumberFormat.getInstance();
            formatter.setParseIntegerOnly(true);
            System.out.println("Test");
            final String nombre = "3.0";
            int entier;
            entier=formatter.parse(nombre).intValue();
            System.out.println("result :" + entier);
        }