String line;
Pattern pattern = Pattern.compile(" "); // Help the GC ;)

while ((line = in.readLine()) != null) {
    String[] data = pattern.split(line);

    // Ugly, but still better than a 8-args constructor
    RGB rgb = new RGB(data, 1, 3);
    CMYK cmyk = new CMYK(data, 4, 4);

    // the best would be a constructor like Color(String[8])
    colors[j++] = new Color(new String(data[0]), rgb, cmyk);
}