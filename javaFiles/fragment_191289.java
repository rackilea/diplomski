int atIndex = valEmail.indexOf('@');
if (atIndex == -1) {
    // Handling for *no* @ sign
}
if (valEmail.indexOf('@', atIndex + 1) != -1) {
    // Handling for multiple @ signs
}