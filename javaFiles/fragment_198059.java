while (val != 0) {
    System.out.print("Enter a Value: ");
    val = s.nextInt();
    if (val != 0) {
        if (val < min) {
            min = val;
        }
        if (val > max) {
            max = val;
        }
    } else {
         break;
    }
}