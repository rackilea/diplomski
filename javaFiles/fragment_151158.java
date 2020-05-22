public void display() {
    System.out.println(usrComment);
    for (Comment c : reply) {
        c.display();
    }
}