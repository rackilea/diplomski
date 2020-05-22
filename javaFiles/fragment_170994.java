Scanner scanner = new Scanner("1945:New York University:70:Ohio State:65");
scanner.useDelimiter(":(\\d\\d:?)?");

while(scanner.hasNext()) {
    System.out.println(scanner.next());
}
scanner.close();