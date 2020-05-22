public static class Utils {

    public static List<String> getFormats() {

    String[] formats = { "pdf", "doc", "docx", "csv", "xls", "xlsx", "odt", "jpg", "png", "jpeg" };

    List<String> list = Arrays.asList(formats);

    return list;

   }

   public static void validateFile(Validation validation, File file) {

    if (file == null)
        throw new IllegalArgumentException("File is null");

    Magic magic = new Magic();
    MagicMatch match;
    try {

        match = magic.getMagicMatch(file, false);

        if (file.length() == 0)
            validation.addError("file", "File is empty");

        if (!getFormats().contains(match.getExtension()))
            validation.addError("file", "Format not valid");

    } catch (MagicParseException | MagicMatchNotFoundException | MagicException e) {
        validation.addError("file", "Format not valid");
    }

   }
}