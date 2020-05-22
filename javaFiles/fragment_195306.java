@Override
public String toString() {
   StringBuilder strB = new StringBuilder();
    for (int i=0; i<this.knowledge.length(); i++) {
        if(this.knowledge.charAt(i)!='[' && this.knowledge.charAt(i)!=']' && this.knowledge.charAt(i)!=',') 
           strB.append(this.knowledge.charAt(i));
    }
    String[] strs = strB.toString().split("\\s+");
    return "{{true@" + strs[0] + ", false@" + strs[1]+ "}@" + strs[2] + "}";
}