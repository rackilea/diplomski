while (!parse.equals("#stop") && !parse.isEmpty()) {
    parse = sc.nextLine();

    String[] line = parse.split("\\s");
    System.out.println(Arrays.toString(line));
}