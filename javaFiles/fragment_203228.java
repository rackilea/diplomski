StringBuffer rvsWords = new StringBuffer();
    String line;

    line = bufRead.readLine();

    int index = 0;

    while (line != null) {
        StringTokenizer tok = new StringTokenizer(line);

        while (tok.hasMoreElements()) {

            String word = (String) tok.nextElement();

            rvsWords.insert(index, " ");
            rvsWords.insert(index, word);

        }

        line = bufRead.readLine();

        if (line != null) {
            rvsWords.append(NEW_LINE_SEPARATOR);
        }

        index = rvsWords.length() - 1;
    }