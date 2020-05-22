// first you need a document
Document MigraDokument  = new Document();

// each document needs at least one section
Section section = MigraDokument.AddSection();
section.PageSetup.PageFormat = PageFormat.A4;

// and then you add paragraphs to the section
Paragraph par = section.AddParagraph();
// and set the alignment as you wish
par.Format.Alignment = ParagraphAlignment.Center;

// now just fill it with content and set the rest of the parameters...
par.AddText("text");