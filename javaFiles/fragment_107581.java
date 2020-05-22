public static ArrayList<Integer> reorder(ArrayList<Integer> list, Integer breakIndex) {
    ArrayList<Integer> reorderedList = new ArrayList<>();
    reorderedList.addAll(list.subList(breakIndex, list.size()));
    reorderedList.addAll(list.subList(0, breakIndex));
    return reorderedList;
}