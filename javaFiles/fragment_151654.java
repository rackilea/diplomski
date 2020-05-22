Pattern regex = Pattern.compile("[$&+,:;=\\\\?@#|/'<>.^*()%!-]");

if (regex.matcher(your_string).find()) {
    Log.d("TTT, "SPECIAL CHARS FOUND");
    return;
}