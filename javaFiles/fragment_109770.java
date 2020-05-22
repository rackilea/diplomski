static boolean isAllPositive(Iterable<Integer> numbers) {
    for (Integer number : numbers) {
        if (number < 0) {
            return false;
        }
    }
    return true;
}

//...
if (isAllPositive(numbers)) {
    System.out.println("Yep!");
}