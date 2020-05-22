public class PaginasProductos {
     private HashMap<String,String> paginasProductos;
     private String[] productos = {"listado", "formularioMod", ...};

     .....

     public PaginasProductos(){
         String rutaTotal = InicializadorXML.getRutaXmlPaginas();
         SAXBuilder constructor = new SAXBuilder();
         File xml = new File(rutaTotal);
         try{
             Document documento = (Document) constructor.build(xml);
             Element root = documento.getRootElement();
             List<Element> listado = root.getChildren("paginasProductos");
             PATH = parametro.getChildText("path");

             for (int contador = 0; contador < listado.size(); contador++){
                 Element parametro = (Element) listado.get(contador);

                 for(String producto:productos){
                     paginasProductos.put(producto, PATH+parametro.getChildText(producto));
                 }
             }
         }
     }

     public String getProducto(String producto){
         return paginasProductos.get(producto)
     }

}