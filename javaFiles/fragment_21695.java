while(sc.hasNextLine()) {
    StringBuilder toPrint = new StringBuilder();
    String line = sc.nextLine();

    for(int i = 0; i < line.length() && line.charAt(i) != ' '; i ++) {
        toPrint.append(line.charAt(i));
    }

    System.out.println(toPrint.toString());
}