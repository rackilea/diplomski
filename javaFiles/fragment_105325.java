private String[] cdSettore;

public void setCdSettore(String[] cdSettore) {
    this.cdSettore = cdSettore;
}
public String[] getCdSettore() {
    return cdSettore;
}

for(int i=0;i<getCdSettore().length;i++){
    System.out.println("not selected :"+getCdSettore()[i]);
}