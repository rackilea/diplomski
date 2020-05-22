value = getAttribute("value").getValue(context);
...
key = getAttribute("key").getValue(context);
...
if (key != null) {
  try {
    w.write(String.format("%s", getLocalizedString(key, bundle)));
  } catch (final Exception cause) {
    if (value != null) {
      w.write(String.format("%s", value));
    } else {
      // exception / invalid key
    }
  }

} else if (value != null) {
  w.write(String.format("%s", value));
} else {
  // exception / do noting
}