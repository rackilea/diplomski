private Integer findMinimum(List<Integer> list) {
    if (list.size() < 2)
        return list.get(0);

    int mid = list.size() / 2;

    // create left and right list
    List<Integer> leftList = list.subList(0, mid);
    List<Integer> rightList = list.subList(mid, list.size());

    if (leftList.get(leftList.size() - 1) <= rightList.get(rightList.size() - 1))
        return findMin(leftList);
    else
        return findMin(rightList);
}