boolean valid = false;
do {
    System.out.print("Code: ");
    code = lector.nextInt();
    if (code > 0 && code < 2000) {
        valid = true;
    }
    i++;
} while (!valid && i < 3);