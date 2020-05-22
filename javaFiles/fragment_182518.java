List<String> stringList = new ArrayList<>();

while (htmlHandler.next()) {
   stringList.add(fromHtml(htmlHandler.readLine()));
}

myTextView.setText(joinStringArray(stringList));