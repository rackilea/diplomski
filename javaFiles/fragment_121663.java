for (String record : records) {

        String[] tokens = record.split(";");

        lecture.setUnitID(tokens[0].trim());
        lecture.setUnitName(tokens[1].trim());
        ...
    }