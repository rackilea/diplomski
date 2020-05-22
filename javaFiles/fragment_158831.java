public String getInfoDerivada(int pos){
    if(pos < 0 || pos >= cont){
        return null;
    }
    return vehiculos[pos].getInfoDerivada();
}