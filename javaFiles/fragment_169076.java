NumberFormat _format = NumberFormat.getInstance(Locale.US);
    Number number = null;
    try {
        number = _format.parse(latitude);
        double _double = Double.parseDouble(number.toString());
        System.err.println("Double Value is :"+_double);
    } catch (ParseException e) {

    }