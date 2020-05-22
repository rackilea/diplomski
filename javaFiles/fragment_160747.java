public class NewClass { 

    static String levels[] = { "div.col-md-9 li a", "div#sidebar ul li a" };    
    static String links = "";   

    private void getRecursive(String href, int level, final ExecutorService executor) { 

        if (level > levels.length - 1) {    
            return; 
        }   

        Document doc;   
        try {   
            doc = Jsoup.connect(href).get();    
            Elements elements = doc.select(levels[level]);  
            final int flevel = ++level; 
            for (final Element element : elements) {    
                executor.execute(new Runnable() {   
                    @Override   
                    public void run() { 
                        if (!element.attr("href").isEmpty()) {  
                            links += element.attr("abs:href") + "\n";   
                            System.out.println(links);  
                            getRecursive(element.attr("abs:href"), flevel, executor);   
                        }   
                    }   
                }); 
            }   
        } catch (IOException e1) {  
            e1.printStackTrace();   
        }   
    }   

    public static void main(String[] args) {    
        ExecutorService executor = Executors.newFixedThreadPool(5); 
        new NewClass().getRecursive("http://www.java2s.com/", 0, executor); 
    }   
}