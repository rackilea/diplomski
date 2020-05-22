try {
  // Use the resource.
} catch( Exception ex ) {
  // Problem with the resource.
} finally {
  // Put away the resource.
  closeQuietly( resource );
}