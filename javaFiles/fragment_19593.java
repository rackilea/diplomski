public abstract class Entity
{
    int id;
    public abstract EntityPdfData getPdfData();
}

// ...

public class CompanyPDFGenerator implements EntityPDFGenerator
{
    public void generate(Entity entity)
    {
        EntityPdfData entityPdfData = entity.getPdfData();
        // create Company related PDF
    }
}