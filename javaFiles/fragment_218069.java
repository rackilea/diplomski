File file = new File("foo.bar");
if(file.setWritable(false)) {
    System.out.println("Successful");
}
else {
    System.out.println("All aboard the fail train.");
}

if(file.setWritable(true)) {
    System.out.println("Re-enabled writing");
}
else {
    System.out.println("Failed to re-enable writing on file.");
}