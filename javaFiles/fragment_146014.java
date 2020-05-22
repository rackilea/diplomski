private void loadDocInReader(String doc) throws ActivityNotFoundException, Exception {

try {
            Intent intent = new Intent();

            intent.setPackage("com.adobe.reader");
            intent.setDataAndType(Uri.parse(doc), "application/pdf");

            startActivity(intent);

} catch (ActivityNotFoundException activityNotFoundException) {
            activityNotFoundException.printStackTrace();
            throw activityNotFoundException;
} catch (Exception otherException) {
            otherException.printStackTrace();
            throw otherException;
}