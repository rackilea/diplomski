int pos = 0;
    while(inputStream.hasNextLine()) {
        String line = inputStream.nextLine();
        String[] lineList = line.split(", ");

        for(int motor = 0; motor < 3; motor++) {
            double lineDouble = Double.parseDouble(lineList[motor]);
            arrayNums[pos][motor] = lineDouble;

        }
        pos++;
    }
System.out.println(Arrays.deepToString(arrayNums));