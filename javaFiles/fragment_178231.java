SimpleDateFormat fen = new SimpleDateFormat("dd/MMMM/yyyy", new Locale("en"));
    SimpleDateFormat ffr = new SimpleDateFormat("dd/MMMM/yyyy", new Locale("fr"));

    Date date = new Date();

    System.out.println(fen.format(date));
    System.out.println(ffr.format(date));