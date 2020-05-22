newCurrValue = ((currValue - 'a') % 26 - 3); // 3 is your shift value

// if the result is negative, simply add 26 (amount of smallercase characters)
if (newCurrValue < 0) {
    newCurrValue += 26;
}
newCurrValue += 'a'; // add 'a' again, to be within 'a' - 'z'