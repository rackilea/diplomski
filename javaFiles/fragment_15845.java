// can't call .equals on something that is null
if (line2array[0] != null && line2array[0].equals(emptyField[0])) {
  Log.v(T, "Located by array element created similar way.");
}
if (line2array[0] != null && line2array[0].equals(tester[0])) {
  Log.v(T, "Located by comparison w just-made array.");
}
if (line2array[0].length() == 0) {
  Log.v(T, "Located by length( ) == 0.");
}
// literals are never null
if ("".equals(line2array[0])) {
  Log.v(T, "Located by zero-len string.");
}
if (line2array[0] == null) {
  Log.v(T, "Located by null.");
}
if (true) {
  Log.v(T, "End");
}