if (nextInt < smallest) {
    secondSmallest = smallest;
    smallest = nextInt;
} else if (nextInt < secondSmallest) {
    secondSmallest = nextInt;
}