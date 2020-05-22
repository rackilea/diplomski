Collections.sort(artOrdenado, new Comparator<Articulo>(){
    public int compare(Articulo uno, Articulo otro){
        return (uno.getPrecio() - otro.getPrecio());
    }

});