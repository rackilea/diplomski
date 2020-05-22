while ((line = readTextFile.readLine()) != null) {
        sb.append(line);
    }
    line = sb.toString();
    line = line.replace("\"", "");
    String[] a = line.split(",");
    System.out.println(a.length);