while ((nextLine = reader.readNext()) != null) {
    try {
        hrUploadValidator.validatePersonDTO(personDTO);
    } catch (Exception ex) {
        // Log / otherwise process your exception here
    }
}