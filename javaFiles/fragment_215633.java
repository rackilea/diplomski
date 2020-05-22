private Instrumento[] repInst;
public RepositorioInstrumentos(){
 repInst = new Instrumento[20];
 }
private int getPos(int id){
    int pos= -1;
    for(int i=0; i<tam; i++){
        if (repInst[i]!=null&&repInst[i].getId()==id){
            pos=i;
            i=tam;
        }
    }
    return pos;
}