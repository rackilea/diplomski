public class bean {
 private String[] clientName ={"tt","bb","gg","ff","tt","gg"};//just for verification

    public String[] getClientName() {
        return clientName;
    }

    public void setClientName(String[] clientName) {
        this.clientName = clientName;
    }

    public void NewVal(String newVal, int index){
    this.clientName[index] = newVal; 
     }

     public String getVal( int index){
    return this.clientName[index] ; 
     }
}