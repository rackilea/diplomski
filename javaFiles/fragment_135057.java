try {
    git.push().setRemote("origin").add("master").call();
} catch (TransportException e) {
    // Add your own logic here, for example:
    System.out.println("Username or password incorrect.");
}