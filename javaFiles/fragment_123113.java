private Objetos findObjetoByNombre(Objetos[] objetos, String nombre){
   for(Objetos objeto: objetos){
      if(objeto.getNombre().equals(nombre){
         return objeto;
      }
   }
   return null;
}