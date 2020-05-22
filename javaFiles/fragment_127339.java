// Here are some examples of how you might call this method.
// The first parameter is the MIME type, and the second parameter is the name
// of the file you are creating:
//
// createFile("text/plain", "foobar.txt");
// createFile("image/png", "mypicture.png");

// Unique request code.
private const val WRITE_REQUEST_CODE: Int = 43
...
private fun createFile(mimeType: String, fileName: String) {
    val intent = Intent(Intent.ACTION_CREATE_DOCUMENT).apply {
        // Filter to only show results that can be "opened", such as
        // a file (as opposed to a list of contacts or timezones).
        addCategory(Intent.CATEGORY_OPENABLE)

        // Create a file with the requested MIME type.
        type = mimeType
        putExtra(Intent.EXTRA_TITLE, fileName)
    }

    startActivityForResult(intent, WRITE_REQUEST_CODE)
}