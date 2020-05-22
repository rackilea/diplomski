List<String> list = new ArrayList<>();

// This is a clever way to create the iterator and call iterator.hasNext() like
// you would do in a while-loop. It would be the same as doing:
//     Iterator<String> iterator = list.iterator();
//     while (iterator.hasNext()) {
for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
    String string = iterator.next();
    if (string.isEmpty()) {
        // Remove the current element from the iterator and the list.
        iterator.remove();
    }
}