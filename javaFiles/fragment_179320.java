private void doCombine(String[] arr, String[] res, int currIndex, int level, int r) {
    if (level == r) {

        printArray(res);
        //Here it doesn't work
        allCombinations.add(res.clone());
        return;
    }
    for (int i = currIndex; i < arr.length; i++) {
        res[level] = arr[i];
        doCombine(arr, res, i + 1, level + 1, r);

        if (i < arr.length - 1 && arr[i].equals(arr[i + 1])) {
            i++;
        }
    }
}