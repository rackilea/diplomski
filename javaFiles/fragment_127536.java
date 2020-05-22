string css = "sup { vertical-align: super; font-size: 0.8em; }";
using (var stream = new MemoryStream())
{
    using (var document = new Document())
    {
        PdfWriter writer = PdfWriter.GetInstance(document, stream);
        document.Open();
        using (var htmlStream = new MemoryStream(Encoding.UTF8.GetBytes(HTML)))
        {
            using (var cssStream = new MemoryStream(Encoding.UTF8.GetBytes(css)))
            {
                XMLWorkerHelper.GetInstance().ParseXHtml(
                    writer, document, htmlStream, cssStream
                );
            }
        }
    }
    File.WriteAllBytes(OUTPUT, stream.ToArray());
}