Locale locale = new Locale("el");
DateFormatSymbols dfs = DateFormatSymbols.getInstance(locale);
for (String m : dfs.getMonths()) {
    System.out.println(m);
}

// output
Μάρτιος
Απρίλιος
Μάϊος
Ιούνιος
Ιούλιος
Αύγουστος
Σεπτέμβριος
Οκτώβριος
Νοέμβριος
Δεκέμβριος