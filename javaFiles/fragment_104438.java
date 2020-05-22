public static void main(String[] args) {
    System.out.println("Escriba el ID Del Cliente");
    String line2;
    File file = new File(yourpathhere);
    int lineCount = 0;
    try {
        PrintWriter output = new PrintWriter(new FileOutputStream(file, true));
        LineNumberReader readers = new LineNumberReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        while ((line2 = readers.readLine()) != null) {
            lineCount++;
            if (line2.contains(CL.getId())) {
                while (line2 != null && readers.getLineNumber() <= lineCount + 3) {
                    System.out.println(line2);
                    line2 = readers.readLine();
                }
                output.close();
                readers.close();
                break;
            }
        }

    } catch (IOException ex) {
        System.out.println("ERRORR!!!!!!");
    }
    }