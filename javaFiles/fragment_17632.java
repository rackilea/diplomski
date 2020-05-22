StringBuilder str = new StringBuilder();
while ((line = br.readLine()) != null) {
    str.append(line);
}
responseData = str.toString();
// now responseData contains the whole String, as you expected