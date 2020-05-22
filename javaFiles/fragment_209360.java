String current;
while ((current = buff.readLine()) != null) {
    System.out.println(current);
    Pattern p = new Pattern(current);
    resultList.add(p);
}