} else if (sArray.get(mid).compareTo(key) > 0) {

    return bSearch(sArray, key, lowIndex, mid + 1);

} else {

    return bSearch(sArray, key, mid - 1, highIndex);
}