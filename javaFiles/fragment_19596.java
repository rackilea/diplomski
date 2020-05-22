<T extends Entity> EntityPDFGenerator<T> getConcretePDFGenerator(T entity, Class<T> classToken)
{
    if(entity instanceof Article){
        return new ArticlePDFGenerator();
    }else{
        return new CompanyPDFGenerator();
    }
}