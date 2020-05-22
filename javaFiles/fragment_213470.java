public class PaginasManager{
    private HashMap<String,String> paginasSections;

    ....

    public PaginasManager(String[] sectionNames){
        for(String sectionName:sectionNames){
            paginasSections.put(sectionName, new Paginas(sectionName));
        }
    }

    public String getPaginas(String section, String page){
        return paginasSections.get(section).get(page);
    }
}