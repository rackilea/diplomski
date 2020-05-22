boolean ascendingOrder = radioButAscending.isSelected();
for (int i = 0; i < numbers.size() - 1; i++) {
    int minNum = i;

    for (int j = i + 1; j < numbers.size(); j++) {
        if (ascendingOrder) {
            if (numbers.get(j) < numbers.get(minNum)) {
                tempNum = numbers.get(i);
                numbers.set(i, numbers.get(j)); //change numbers[i] to numbers[j] (numbers.get(i) = numbers.get(j))
                numbers.set(j, tempNum); //numbers.get(j)=tempNum
            }
        } else {
            if (numbers.get(j) > numbers.get(minNum)) {
                tempNum = numbers.get(i);
                numbers.set(i, numbers.get(j)); //change numbers[i] to numbers[j] (numbers.get(i) = numbers.get(j))
                numbers.set(j, tempNum); //numbers.get(j)=tempNum
            }
        }
    }
}
showSortedNumbers();