public enum StateType { 

ALABAMA("AL", 1, "Alabama"), 
      etc 

StateType(String abbreviation, int code, String displayText) { 
    this.abbreviation = abbreviation; 
    this.code = code; 
    this.displayText = displayText; 
} 

public String getDisplayText() {
   return this.displayText;
}

      public String toString() { 
         return displayText; 
      }