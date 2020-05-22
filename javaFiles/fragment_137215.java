public void replaceWords() {
    ArrayList<String> lns = new ArrayList<String>();
    for (String ln : lines){
        lns.add(ln.replaceAll("this", "****"));
    }
    lines.clear();
    lines = lns;
    System.out.println(lines);
}