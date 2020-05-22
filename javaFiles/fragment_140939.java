public void doConstrainList(List<String> liste, String constraint) {

    System.out.println("List initial state: " + liste);
    if (liste.remove(constraint)) {
        liste.add(0, constraint);
    }

    System.out.println("List state after processing:" + liste);
}