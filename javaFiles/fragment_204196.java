static void swap(Container panel,
                 int firstIndex,
                 int secondIndex) {

    if (firstIndex == secondIndex) {
        return;
    }

    if (firstIndex > secondIndex) {
        int temp = firstIndex;
        firstIndex = secondIndex;
        secondIndex = temp;
    }

    Component first = panel.getComponent(firstIndex);
    Component second = panel.getComponent(secondIndex);

    panel.remove(first);
    panel.remove(second);

    panel.add(second, firstIndex);
    panel.add(first, secondIndex);
}