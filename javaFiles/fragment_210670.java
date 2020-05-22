URI users = URI.create("/users"); // Can be put as a final static field

URI uri = URI.create(uriString);  // Can be skipped if you have a URI as input

String afterUsers = users.relativize(uri).getPath();
if (afterUsers.isEmpty())
    System.out.println("No user");
else
    System.out.println("User: " + afterUsers.split("/", 2)[0]);