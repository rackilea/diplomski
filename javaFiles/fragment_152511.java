double d, d2, d3, d4;
if (tryParseDouble(input)) {
    d = parseDouble(input);

    if (tryParseDouble(input2)) {
        d2 = parseDouble(input2);

        if (tryParseDouble(input3)) {
            d3 = parseDouble(input3);

        } else {
            if (tryParseDouble(input4)) {
                d4 = parseDouble(input4);

            } else {
                System.out.println("Cannot parse " + input4);
            }

            System.out.println("Cannot parse " + input3);
        }

    } else {
        System.out.println("Cannot parse " + input2);
    }

} else {
    System.out.println("Cannot parse " + input);
}