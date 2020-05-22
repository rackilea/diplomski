if(result == null)  
   result = new StringBuffer("");

mailBody = mailBody.trim();

while(mailBody.length() > 125) {

    // Try not to break immediately before closing punctuation
    Matcher m = Pattern.compile("^.{1,125}\\b(?![-\\.?;&)])").matcher(mailBody);
    String oneLineString;

    // Found a safe place to break string
    if (m.find()) {

        oneLineString = m.group(0);

    // Forced to break string in an ugly fashion
    } else {

        // Try to break at any word boundary at least
        m = Pattern.compile("^.{1,125}\\b").matcher(mailBody);

        if (m.find()) {

            oneLineString = m.group(0);

        // Last ditch scenario, just break at 125 characters
        } else {

            oneLineString = mailBody.substring(0,124);

        }

    }

    result.append(oneLineString + "\n");
    mailBody = mailBody.substring(oneLineString.length(),
                                  mailBody.length()).trim();  
}

result.append(mailBody);