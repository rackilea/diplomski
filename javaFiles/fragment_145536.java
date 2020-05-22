public Sequence(String s) {
    String [] terms = s.split (",");
    sequence = new Double[terms.length];
    for (int i = 0; i < terms.length; i++) {
        sequence[i] = Double.parseDouble(terms[i]);
    }
 }