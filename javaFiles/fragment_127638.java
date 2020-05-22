boolean isDuplicate = isMailAlreadyRegistered(email);
if (!isDuplicate) {
    writer.write("Email : "+email);
    writer.println();
} else {
    System.out.println("E-mail already registered");
}