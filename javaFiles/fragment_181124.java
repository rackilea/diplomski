Uri uri = file.getUri();

try (OutputStream o = context.getContentResolver().openOutputStream(uri))
{
  // I/O operations
} (catch FileNotFoundException e) {
    try (OutputStream s = context.getContentResolver().openInputStream(uri)) {
         // the file can be opened for reading, but not for writing
         // ask user to reinsert SD card and/or disable
         // write protection toggle on it
         Toast.makeText(context, "Please reinsert SD card", LENGTH_SHORT);
    } catch (FileNotFoundException err) {
         // This is hopeless, just report error to user
         Toast.makeText(context, err.toString(), LENGTH_SHORT);
    }
}