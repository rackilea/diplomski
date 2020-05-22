public int[] getRandomData(ArrayList<Integer> list, int count) {
    int[] result = new int[count];
    while (count > 0 && list.size() > 0) {
         int index = (int) (Math.random() * list.size());
         result[count - 1] = list.get(index);
         list.remove(index);
         count--;
    }
    return result;
}