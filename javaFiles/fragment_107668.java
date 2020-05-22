if (largest < ar[i]) {
    thirdlargest = secondlargest;
    secondlargest = largest;
    largest = arr[i];
} else if (secondlargest < ar[i]) {
    thirdlargest = secondlargest;
    secondlargest = ar[i];
} else if (thirdlargest < ar[i]) {
    thirdlargest = ar[i];
}