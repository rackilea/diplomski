boolean firstRound = true;
for (CSVRecord csvRecord : csvParser) {
    if(firstRound){
        firstRound = false;
    } else {
        String name = csvRecord.get(0);
        dates_csv.add(name);
    }
}