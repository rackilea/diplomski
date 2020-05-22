public void filterTitle(String s) {
    int n = 0;
    s = s.split(":")[1];
    if (n == 0) {
        System.out.println("Program is processing.");
        n++;
        for (Song song1 : songs2) {
            if (song1.title.contains(s) == false) {
                itemsToRemove.add(song1);
            }
        }
        songs2.removeAll(itemsToRemove);
        itemsToRemove.clear();
    }
    System.out.println(songs2);
}