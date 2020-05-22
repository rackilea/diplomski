// Read in the whole file
String[] strLines = File.ReadAllLines(strFilePath);

// Loop through each of the lines to process their contents
foreach (String strLine in strLines) {
    // Tokenize on the spaces
    String[] strTokens = strLine.Split(' ');

    // Parse the values
    int iIntValue = Int.Parse(strTokens[0]);
    double dDoubleValue = Double.Parse(strTokens[1]);

    // Do something with the values
}