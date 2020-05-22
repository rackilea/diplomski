String code = input.nextLine().toLowerCase();

// keep your length check

if (code.charAt(0) != 'i' && code.charAt(0) != 'I') {
    System.out.println("First Letter is not i or I: "  + code.charAt(0));
}

// similar for char 1

if (!Character.isDigit(code.charAt(2))) {
    System.out.println("Third character is not a digit: " + code.charAt(2) );
}

// similar for chars 3-5