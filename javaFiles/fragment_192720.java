try {
    denom = Integer.parseInt(s.next());
    ...
} catch (NumberFormatException nfe) {
    System.out.print("Enter an integer:");
    continue;
} catch (...) {