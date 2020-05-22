private void checkDataFile(String filePath) {
    String ls = System.lineSeparator();
    List<String> validationFailures = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    // 'Try With Resources' used here to auto-close reader.
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        int lineCount = 0;
        // Read the file line-by-line.
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            lineCount++;
            if (lineCount == 1 || line.equals("")) {
                continue;
            }
            sb.delete(0, sb.capacity()); // Clear the StringBuilder object

            // Start the Status Log
            sb.append("File Line Number: ").append(lineCount)
                    .append(" (\"").append(line).append("\")").append(ls);
            // Split line into an Array based on a comma delimiter
            // reguardless of the delimiter's spacing situation.
            String[] lineParts = line.split("\\s{0,},\\s{0,}");
            /* Validate each file line. Log any line that fails
               any validation for any record column data into a
               List Interface object named: validationFailures
             */
            // Are there 4 Columns of data in each line...
            if (lineParts.length < 4) {
                sb.append("\t- Invalid Column Count!").append(ls);
                // Which column is missing...
                // *** You may need to add more conditions to suit your needs. ***
                if (checkAccountIDs(lineParts[0]) && lineParts.length >= 2 && !checkAccountIDs(lineParts[1])) {
                    sb.append("\t- Either the 'Sender Account ID' or the "
                            + "'ReceiverAccountID' is missing!").append(ls);
                }
                else if (lineParts.length >= 3 && !checkAmount(lineParts[2])) {
                    sb.append("\t- The 'Amount' value is missing!").append(ls);
                }
                else if (lineParts.length < 4) {
                    sb.append("\t- The 'Transfer Date' is missing!").append(ls);
                }
            }
            else {
                // Is SenderAccountID data valid...
                if (!checkAccountIDs(lineParts[0])) {
                    sb.append("\t- Invalid Sender Account ID in column 1! (")
                            .append(lineParts[0].equals("") ? "Null" : 
                                    lineParts[0]).append(")");
                    if (lineParts[0].length() < 9) {
                        sb.append(" <-- Not Enough Or No Digits!").append(ls);
                    }
                    else if (lineParts[0].length() > 9) {
                        sb.append(" <-- Too Many Digits!").append(ls);
                    }
                    else {
                        sb.append(" <-- Not All Digits!").append(ls);
                    }
                }
                // Is ReceiverAccountID data valid...
                if (!checkAccountIDs(lineParts[1])) {
                    sb.append("\t- Invalid Receiver Account ID in coloun 2! (")
                            .append(lineParts[1].equals("") ? "Null" : 
                                    lineParts[1]).append(")");
                    if (lineParts[1].length() < 9) {
                        sb.append(" <-- Not Enough Or No Digits!").append(ls);
                    }
                    else if (lineParts[1].length() > 9) {
                        sb.append(" <-- Too Many Digits!").append(ls);
                    }
                    else {
                        sb.append(" <-- Not All Digits!").append(ls);
                    }
                }
                // Is Amount data valid...
                if (!checkAmount(lineParts[2])) {
                    sb.append("\t- Invalid Amount Value in column 3! (")
                            .append(lineParts[2].equals("") ? "Null" : 
                                    lineParts[2]).append(")").append(ls);
                }
                // Is TransferDate data valid...
                if (!checkTransferDate(lineParts[3], "yyyy-MM-dd HH:mm:ss")) {
                    sb.append("\t- Invalid Transfer Date Timestamp in column 4! (")
                            .append(lineParts[3].equals("") ? "Null" : 
                                    lineParts[3]).append(")").append(ls);
                }
            }
            if (!sb.toString().equals("")) {
                validationFailures.add(sb.toString());
            }
        }
    }
    catch (FileNotFoundException ex) {
        System.err.println(ex.getMessage());
    }
    catch (IOException ex) {
        System.err.println(ex.getMessage());
    }

    // Display the Log...
    String timeStamp = new SimpleDateFormat("yyyy/MM/dd - hh:mm:ssa").
            format(new Timestamp(System.currentTimeMillis()));
    String dispTitle = "File Data Status at " + timeStamp.toLowerCase() 
                     + " <:-:> (" + filePath + "):";
    System.out.println(dispTitle + ls + String.join("", 
            Collections.nCopies(dispTitle.length(), "=")) + ls);
    if (validationFailures.size() > 0) {
        for (String str : validationFailures) {
            if (str.split(ls).length > 1) {
                System.out.println(str);
                System.out.println(String.join("", Collections.nCopies(80, "-")) + ls);
            }
        }
    }
    else {
        System.out.println("No Issues Detected!" + ls); 
    } 
}

private boolean checkAccountIDs(String accountID) {
    return (accountID.matches("\\d+") && accountID.length() == 9);
}

private boolean checkAmount(String amount) {
    return amount.matches("-?\\d+(\\.\\d+)?");
}

private boolean checkTransferDate(String transferDate, String format) {
    return isValidDateString(transferDate, format);
}

private boolean isValidDateString(String dateToValidate, String dateFromat) {
    if (dateToValidate == null || dateToValidate.equals("")) {
        return false;
    }
    SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
    sdf.setLenient(false);
    try {
        // If not valid, it will throw a ParseException
        Date date = sdf.parse(dateToValidate);
        return true;
    }
    catch (ParseException e) {
        return false;
    }
}