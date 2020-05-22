while (email != null) {
    printDepth();
    System.out.println("Email: "+email.getSubject());
    System.out.println(email.getBody());// add this line
    email = (PSTMessage)folder.getNextChild();
}