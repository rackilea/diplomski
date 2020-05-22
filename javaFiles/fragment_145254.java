public static void main(String[] args) {
        NumberFormat nf = NumberFormat.getInstance(Locale.FRENCH); //Set the proper locale here

        try {
            Double myDouble = (Double)nf.parse("0,55");
            System.out.println(myDouble);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }