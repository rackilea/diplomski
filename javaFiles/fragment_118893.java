int c = 1;
for (int d = 0; d < 10; d++) {
    // 1. When we are here for the first time, c = 1, both if are false
    // 4. Now, c is equal to 6 so the first if is true, "Hello World 1" is printed
    // 7. Now, c is equal to 11, both if are false, nothing is printed...
    if (c == 6) {
        System.out.println("Hello World 1");
    } else if (c == 7) {
        System.out.println("Hello World 2");
    }
    for (int e = 0; e < 5; e++) {
        // 2. We reach here, c is incremented 5 times.
        // 5. c is incremented again 5 times
        System.out.println("This is the nested for loop :" +c);
        c++;
    }
    // 3. When we're here, c that was 1 is now 6 (incremented 5 times in step 2)
    // 6. When we're here for the second time, c is now 11 (6 incremented 5 times in step 5)
}