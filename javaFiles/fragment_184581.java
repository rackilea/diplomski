public Boolean prendiTessera(TipoTerreno tipo) {
    boolean flag=true;
    switch (tipo) {

        case PIANURA: flag=tesserePianura != 4 ? true :false; break;

        case CAMPAGNA: flag=tessereCampagna != 4 ? true : false;break;

        case MONTAGNA: flag=tessereMontagna != 4 ? true : false;break;

        case DESERTO: flag=tessereDeserto != 4 ? true : false;break;

        case FIUME: flag=tessereFiume != 4 ? true : false;break;

        case BOSCO: flag=tessereBosco != 4 ? true : false;break;

        default: flag=false;  
    }
    if (flag)
        tessereMontagna++;
    return flag;
}