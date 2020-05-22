public String gen(){
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < series; i++){
        sb.append(Integer.toString(randomInt(1,1000)));
        sb.append(SEPERATOR); 
    }
    return sb.toString();
}