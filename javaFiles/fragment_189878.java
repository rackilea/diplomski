for (int i = 10; i > 0; i--) {
    if (i ==5) {
        return String.valueOf(i);
    }
    if (i == 6) {
        return String.valueOf(i);
    }
}

throw new RuntimeException("Unexpected error occured");