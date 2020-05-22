File file = new File("foo.bar");
if(file.setReadOnly()) {
    System.out.println("Successful");
}
else {
    System.out.println("All aboard the fail train.");
}