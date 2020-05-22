public class Paginas {
     private HashMap<String,String> paginas;

     .....

     // sectionName = "paginasProductos", etc.
     public Paginas(String sectionName ){
         String rutaTotal = InicializadorXML.getRutaXmlPaginas();
         SAXBuilder constructor = new SAXBuilder();
         File xml = new File(rutaTotal);
         try{
             Document documento = (Document) constructor.build(xml);
             Element root = documento.getRootElement();
             List<Element> listado = root.getChildren(sectionName );
             PATH = parametro.getChildText("path");

             for (int contador = 0; contador < listado.size(); contador++){
                 Element parametro = (Element) listado.get(contador);
                 paginas.put(parametro.getTagName(), PATH+parametro.getChildText(producto));
             }
         }
     }

     public String getPaginas(String page){
         return paginas.get(page);
     }

}