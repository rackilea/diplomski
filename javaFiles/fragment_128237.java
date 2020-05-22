public static void parseData(String data) {
    String[] args = data.split("\\s+");
    for (int i=2; i<7; i+=2) {
        if (args[i].charAt(args[i].length() - 1) == '?') {
            args[i] = args[i].substring(0, args[i].length() - 1);
        }
        double val = Double.parseDouble(args[i]) / 10;
        System.out.println("Temp[" + (i-1)/2 + "]= " + val);
    }
}