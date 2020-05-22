//you can iterate over each item and add it to an ArrayList like this:

//i am showing you a single one,follow the same process for other arrays:

ArrayList titlesArray = new ArrayList();

for (int i = 0; i < jTitles.length(); i++) {
String item = jTitles.getString(i);
titlesArray.add(item);

}