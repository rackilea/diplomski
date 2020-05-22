Rectangle left = new Rectangle(0, 0, 306, 792);
Rectangle right = new Rectangle(306, 0, 612, 792);
RenderFilter leftFilter = new RegionTextRenderFilter(left);
RenderFilter rightFilter = new RegionTextRenderFilter(right);
[...]
TextExtractionStrategy strategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(), leftFilter);
original_content = PdfTextExtractor.getTextFromPage(reader, 2, strategy);
originalContent += " ";
strategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(), rightFilter);
original_content += PdfTextExtractor.getTextFromPage(reader, 2, strategy);