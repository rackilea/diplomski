input = input.replaceAll(",", ".");

    double number = Double.parseDouble(input);
    long longBits = Double.doubleToLongBits(number);
    String result = Long.toBinaryString(longBits);
    StringBuilder builder = new StringBuilder();
    for (int i = result.length(); i < 64; i++) {
        builder.append('0');
    }
    return builder.append(result).toString();