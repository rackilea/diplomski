try (Scanner s = new Scanner(new FileInputStream("node.txt"))) {
    while(s.hasNext()) {
        System.out.println(s.next());
    }
} catch (Exception e) {
    e.printStackTrace();
}