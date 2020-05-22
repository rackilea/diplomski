String[] result = conversionText.split("//n");

for (int a = 0; a < result.length; a++) {
    result[a] = result[a].replaceAll("important", " <br><u>IMPORTANT</u>");
}

verifyTextView.setText(Html.fromHtml(Arrays.toString(result)));