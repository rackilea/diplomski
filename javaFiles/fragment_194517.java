for (int i = 0; i < comb.codigo.length; i++) {
    if(clave.contains(comb.codigo[i])){
        aciert++;
        clave.remove(Character.valueOf(comb.codigo[i]));
    }
}