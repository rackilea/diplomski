for (int c = 0; c < 128; c++) { 
    // String hex = Integer.toString(c , 16); - No need for this anymore.

    // Print the output with printf to create the columns
    // character (c), string(s), decimal integer(d)
    System.out.printf("%-2c 0x%-2X %-2d%n", (char)c, c, c);
}