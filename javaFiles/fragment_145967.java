private void sortList(ArrayList<MyRenderable> array) {
    // double starttime = System.nanoTime();
    for (int i = 1; i < array.size(); i++) {
        final MyRenderable temp = array.get(i);
        int j = i - 1;

        while (j >= 0 && array.get(j).getZ_index() < temp.getZ_index()) {
            array.set(j + 1, array.get(j));
            j--;
        }
        array.set(j + 1, temp);
    }
    // System.out.println("Time taken: " + (System.nanoTime() - starttime));
}