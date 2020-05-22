public static interface EntityPDFGenerator<T extends Entity>
{
    void generate(T entity);
}

public static class ArticlePDFGenerator implements EntityPDFGenerator<Article>
{
    public void generate(Article entity)
    {
        Article article = (Article) entity;
        // create Article related PDF from entity
    }
}

public static class CompanyPDFGenerator implements EntityPDFGenerator<Company>
{
    public void generate(Company entity)
    {
        Company company = (Company) entity;
        // create Company related PDF
    }
}