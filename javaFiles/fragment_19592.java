public class CompanyPDFGenerator implements EntityPDFGenerator
{
    public void generate(Entity entity)
    {
        if (! (entity instanceof Company)) {
            throw new IllegalArgumentException("CompanyPDFGenerator works with Company object. You provided " + (entity == null ? "null" : entity.getClass().getName()));
        }
        Company company = (Company) entity;
        System.out.println(company);
        // create Company related PDF
    }
}