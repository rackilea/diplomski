int sharedLength = Math.min(a.length, b.length);
for (int i = 0; i < sharedLength; ++i) {
    if (a[i].equals(b[i])) {
        System.out.println(a[i] + "\t" + b[i]);
    } else {
        System.out.println(a[i] + "--" + b[i]);
}

// Here, you could either use an if statement to find the longer array
// Or, more elegantly(?), just loop over both of them.
// One of these loops will not execute because the array is too short:
for (int i = sharedLength; i < a.length; ++i) {
    System.out.println(a[i] + "--");
}
for (int i = sharedLength; i < b.length; ++i) {
    System.out.println("\t--" + b[i]);
}