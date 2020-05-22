public static List<ArticleModele> readWithCsvDozerBeanReader() throws Exception { 
    List<ArticleModele> articleModele = new ArrayList<>();
    ArticleModele articleModele;
    while( (articleModele = beanReader.read(ArticleModele.class, processors))
         != null)             {
        System.out.println(articleModele);
        articleModeles.add(articleModele);
    }
    return articleModeles;