StringBuilder sb = new StringBuilder();

try (BufferedReader reader = new BufferedReader(new FileReader("node.txt"))) {

    String line;
    while ((line = reader.readLine()) != null) {
        sb.append(line);
    }

} catch (Exception e) {
    // TODO: handle exception
}


int index = sb.indexOf("settings.bluetooth");
if (index != -1)
    System.out.println(sb.substring(index, index + 18));