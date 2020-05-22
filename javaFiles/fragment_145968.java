public static void sortRenderables(ArrayList<MyRenderable> array) {
    for (int i = 1; i < array.size(); i++) {
        final MyRenderable temp = array.get(i);
        int j = i - 1;

        while (j >= 0 && array.get(j).getZ_index() < temp.getZ_index()) {
            array.set(j + 1, array.get(j));
            j--;
        }
        array.set(j + 1, temp);
    }
}

public static void sortGroup(ArrayList<Group> array) {
    for (int i = 1; i < array.size(); i++) {
        final Group temp = array.get(i);
        int j = i - 1;

        while (j >= 0 && array.get(j).groupType < temp.groupType) {
            array.set(j + 1, array.get(j));
            j--;
        }
        array.set(j + 1, temp);
    }
}