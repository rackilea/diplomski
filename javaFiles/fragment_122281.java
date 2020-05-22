pad = ""    # Empty string

 builder = "SELECT ";
 if (addOpen)
     builder += pad + "Open";   pad = ", ";
 if (addHigh)
     builder += pad + "High";   pad = ", ";
 if (addLow)
     builder += pad + "Low";    pad = ", ";
 if (addSettle)
     builder += pad + "Settle"; pad = ", ";
 builder += "FROM " + TableName;