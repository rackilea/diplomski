/* 
  Query the given URI, returning a {@link Cursor} over the result set.
  For best performance, the caller should follow these guidelines:
   - Provide an explicit projection, to prevent reading data from storage that aren't going to be used.
   - Use question mark parameter markers such as 'phone=?' instead of explicit values in the {@code selection} parameter, so that queries that differ only by those values will be recognized as the same for caching purposes.

   @param uri The URI, using the content:// scheme, for the content to retrieve.
   @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
   @param selection A filter declaring which rows to return, formatted as an SQL WHERE clause (excluding the WHERE itself). Passing null will return all rows for the given URI.
   @param selectionArgs You may include ?s in selection, which will be replaced by the values from selectionArgs, in the order that they appear in the selection. The values will be bound as Strings.
   @param sortOrder How to order the rows, formatted as an SQL ORDER BY clause (excluding the ORDER BY itself). Passing null will use the default sort order, which may be unordered.
   @return A Cursor object, which is positioned before the first entry, or null
   @see Cursor
 */

  public final Cursor query(Uri uri, String[] projection,
        String selection, String[] selectionArgs, String sortOrder)