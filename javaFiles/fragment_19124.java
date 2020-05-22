String[] splitRecordLineItems = recordLine.split("\t");
    Character[] resultsArray = new Character[splitRecordLineItems.length];

    for (int i = 0; i < splitRecordLineItems.length; i++) {
        try {
            long l = Long.parseLong(splitRecordLineItems[i]);
            resultsArray[i] = 'L';
        } catch (NumberFormatException nfe) {
            resultsArray[i] = 'S';
        }
    }