public void generate(Entity entity)
{
    // either Article or Company can come it. It's a general method
    EntityPDFGenerator pdfGenerator = getConcretePDFGenerator(entity);
    pdfGenerator.generate(entity);

}