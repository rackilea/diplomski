while ((line = br.readLine()) != null) {
    line = line.trim();
    line = line.replaceAll("/t", "");
    line = line.toLowerCase();

    // New code
    String[] tokens = line.split(" ");
    buy.add(Integer.valueOf(tokens[1]));
    price.add(Integer.valueOf(tokens[3]));
}