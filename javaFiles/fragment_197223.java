public String toString() {

    StringBuffer buffer = new StringBuffer();
    for (Term term = head; term != null; term = term.getNext()) {
        if (term.coeff < 0)
            buffer.insert(0, " - " + term.toString());
        else
            buffer.insert(0, " + " + term.toString());
    }

    if (buffer.charAt(1) == '+') {
        return buffer.substring(2);
    else {
        return buffer.toString(); 
    }
}