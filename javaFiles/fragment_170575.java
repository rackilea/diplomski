// Get the length of text to trim.
final int trimLength = "com.android.".length();

// Loop over each item.
for (ResolveInfo info : listP) {
    // Get the (full, qualified) package name.
    String package = info.activityName.packageName;

    // Now, trim it with substring and the trim length.
    String trimmed = package.substring(trimLength);

    // [ do whatever you want with the trimmed name ]
}