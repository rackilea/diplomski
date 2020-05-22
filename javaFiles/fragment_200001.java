/**
 * Class that knows how to remove OCG layers.
 */
public class OCGRemover
{
    /**
     * Removes layers from a PDF document
     * @param reader    a PdfReader containing a PDF document
     * @param layers    a sequence of names of OCG layers
     * @throws IOException
     */
    public void removeLayers(PdfReader reader, String... layers) throws IOException
    [...]
}