public static int[] findIndex(BufferedImage image, int value) {
    DataBuffer b = image.getRaster().getDataBuffer();
    ArrayList<Integer> a = new ArrayList<>(20);

    int j = 0;
    for (int i = 0; i < b.getSize(); i++) {
        if (b.getElem(i) >= value) {
            a.add(i);
            j++;
        }
    }
    int array[] = new int[a.size()];
    for (int k = 0; k < a.size(); k++) {
        array[k] = a.get(k);
    }
    return array;
}