ArticleModele articleModele;
while( (articleModele = beanReader.read(ArticleModele.class, processors))
        != null)             {
    System.out.println(articleModele);
}
return articleModele;