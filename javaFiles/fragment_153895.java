public void printResults() {
    for (Dragster d: DragsterList) {
        System.out.println(d.toString());
        System.out.println();
        System.out.println("Dragster time:" + d.race());
    }
}