if(!CollectionUtils.isEmpty(list)) {
    if(list.size() > 10) {
        mergeSort(list);
    } else {
        bubbleSort(list);
    }
}