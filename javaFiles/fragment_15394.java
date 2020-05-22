StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new FileReader(PATH_TO_XML_FILE));
    String sCurrentLine = null;

    while ((sCurrentLine = br.readLine()) != null) {
        sb.append(sCurrentLine);
    }

    Pattern pattern = Pattern.compile("A:");
    Matcher matcher = pattern.matcher(sb);
    int count = 0;
    while (matcher.find()){
        count++;
    }

    System.out.println(count);