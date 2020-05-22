while ((line = br.readLine()) != null) { 
StringTokenizer stringTokenizer = new StringTokenizer(line, "\n");

while (stringTokenizer.hasMoreElements()) {
    String function = stringTokenizer.nextElement().toString();

    if (function.matches("\\s*((unsigned int)|float|int|char|void|double)(\\s)+[a-zA-Z_](\\w)*(\\s)*\\((\\s)*((((unsigned int|float|int|char|double)(\\s)*,(\\s)*)*((unsigned int|float|int|char|double)(\\s)*))|(\\s)*|(void)(\\s)*)\\)(\\s)*\\;")) {
        System.out.println("VALID - ");
    }
}