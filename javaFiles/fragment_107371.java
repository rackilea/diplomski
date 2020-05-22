if (palabra.contains(opcion))
    {
        int Indice = palabra.indexOf(opcion);
        incognita = new StringBuilder( incognita ).replace( 1+2*Indice, 2+2*Indice, opcion ).toString();
        System.out.println(Indice);
        aciertos++; 
    }