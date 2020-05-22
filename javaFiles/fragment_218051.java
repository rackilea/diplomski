@Value("${aes.encryption.cipherString}")
private String cyperString;

public String getCypherString(){
    return this.cyperString;
}