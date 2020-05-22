public static void main(String[] args) throws Exception {
try {
    // NB: controllate di importare le classi giuste
    // all'inizio ci deve essere org.jsoup

    // ricavo l'html della pagina con user agent desktop (Chrome)
    // e timeout 30000
    Document doc = Jsoup.connect("http://www.androidiani.com/forum")
        .userAgent("Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.172 Safari/537.22")
        .timeout(30000).get();

    // prendo la tabella
    // (con .first() ottengo il primo elemento, in questo caso l'unico )
    Element tabella = doc.getElementById("forums");

    // prendo gli elementi che mi interessano dalla tabella
    Elements sezioni = tabella.select(".foruminfo.td");
    for(Element sezione : sezioni)//per ogni sezione tra gli elementi ricavati prima
    {
        //ricavo ogni riga nella sezione
        Elements righe_sezione = sezione.getElementsByClass("foruminfo");
        for(Element riga : righe_sezione)
        {
            //prelevo la cella delle info
            Element info = riga.getElementsByClass("datacontainer").first();

            // ricavo il titolo
            // (con .text() ottengo il testo non formattato
            String titolo = info.getElementsByClass("forumtitle").first().text();

            // ricavo la descrizione
            // (uso .first() per essere sicuro che sia proprio la descrizione
            // e non i moderatori )
            String descrizione = info.getElementsByTag("p").first().text();

            // inserisco nei rispettivi arraylist

            System.out.println("titolo = " + titolo);
            System.out.println("descrizione = " + descrizione);
        }
    }
} catch (Exception e) {
    // gestione dell'eccezione
    // ad esempio mostrare messaggio di errore o altro (qui nel logcat)
    e.printStackTrace();
}
}