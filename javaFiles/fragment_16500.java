Set<Map.Entry<String, String>> buttons = buttonColors.entrySet();
Iterator sortingItr = buttons.iterator();
while (sortingItr.hasNext()) {
    Map.Entry<String, String> entry = (Map.Entry) sortingItr.next();
                                                  ^^^^^^^^^^^^^^^^^
    System.out.println(sortingItr.next());
                       ^^^^^^^^^^^^^^^^^^
}