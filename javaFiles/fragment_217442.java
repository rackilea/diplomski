public String toString() { 
    String outputStr = ""; 
    for (int index = 0; index < length; ++index) { 
        outputStr += "No: "+(index+1)+" "+playerList[index] + "\n"; 
    } 
    return outputStr; 
}