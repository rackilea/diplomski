String input = new File(Environment.getExternalStorageDirectory(), "Document1.pdf").toString();
// Load the PDF document
Document doc = new Document(input);
// Create a text absorber
TextAbsorber absorber = TextAbsorber();
// Accept page 1 for absorber.
doc.getPages().get_Item(1).accept(absorber);
// Extract all text from page 1
String text = absorber.getText();
Log.i("PDF", text);