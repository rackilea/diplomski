byte[] imageBytes = rs.getBytes("doctimg");
if (rs.wasNull()) {
    System.out.println("It was null!"); // or some more robust treatment
} else {
    // Wasn't null, let's use it
    String imageBase64 = DatatypeConverter.printBase64Binary(imageBytes);
}