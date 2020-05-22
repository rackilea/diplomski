System.out.println(balance);

// replace original value with the modified balance
values[11] = String.valueOf(balance);

// iterate through the values and build a string out of them
StringBuilder sb = new StringBuilder();
for (int i = 0; i < values.length; i++) {
    sb.append(values[i]);
    if (i < values.length - 1) {
        // if it is not the last value, put a semicolon in between
        sb.append(";");
    }
}
// get the new string
String newData = sb.toString();

System.out.println(newData);