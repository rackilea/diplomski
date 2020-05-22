check=duplicate(email);
if (!check) {
    writer.write("Email : "+email);
    writer.println();
} else {
    System.out.println("E-mail already registered");
}