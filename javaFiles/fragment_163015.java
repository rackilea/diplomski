Datum() {
    newDatum(this);
}

public static void newDatum(Datum instance) {
    String input = Opgave5.userInput("Geboortedatum gast"); 
    boolean b = input.matches(patroon); 

    if (b) {
        String[] str = input.split("-");

        int dag = Integer.parseInt(str[0]);
        int maand = Integer.parseInt(str[1]);
        int jaar = Integer.parseInt(str[2]);

        instance.dag = dag;
        instance.maand = maand;
        instance.jaar = jaar;
        System.out.println(instance);
    }
    else {
        new Datum();
    }
    // ^^ Above code may be buggy, see my answer above code
}