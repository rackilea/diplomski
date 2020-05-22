String str = "Test something Test";

// Look for the first occurence of "Test".
int idx = str.indexOf("Test");

// Counter that will be used as the replacement.
int i = 1;

// While "Test" was found in the string ...
while (idx >= 0) {
    // ... replace it with the current counter value, increase it afterward ...
    str = str.replaceFirst("Test", "" + i++);

    // ... and find the next occurence of "Test".
    idx = str.indexOf("Test");
}

// The result.
System.out.println(str);