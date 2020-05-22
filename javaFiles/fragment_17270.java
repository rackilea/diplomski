String s = "To track your packages, enter COP201812345 and COP201867890 at www.example.org";
Matcher m = Pattern.compile("\\bCOP(201[5-8])(\\d{5})\\b").matcher(s);

while (m.find()) 
    System.out.println(
        "Match: " + m.group() + 
        " (Year: " + m.group(1) + ", Id: " + m.group(2) + ")");
}