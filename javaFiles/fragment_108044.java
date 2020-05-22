for (int j = 1; j < contador; j++){
    nodo.nodosanterior=nodo;
    nodo.nodosiguiente=null;
}

for (int k = 1; k <= n; k++){
    System.out.println("nombre " +nodo.nombre);
    System.out.println("apuntador " +nodo.nodosiguiente);    
}