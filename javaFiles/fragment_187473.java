public double returnAverage(int...numbers) {
    for(int i = 0; i < numbers.length(); i++) {
        total += numbers;
    }

    return total/numbers.length();
}

public int returnRange(int...numbers) {
    int holder = 0;

    int highest;
    int lowest;

    for(int i = 0; i < numbers.length(); i++) {
        if(numbers[i] > holder) {
            holder = numbers[i];
    }
    highest = holder;

    for(int i = 0; i < numbers.length(); i++) {
        if(numbers[i] < holder) {
            holder = numbers[i];
        }
    }
    lowest = holder;

    return highest-lowest;
}