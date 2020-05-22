public short[] buildShortArray(List<Short> list) {

    short[] array = new short[list.size()];

    for(int i = 0; i < list.size(); i++) {
        array[i] = list.get(i);
    }

    return array;
}