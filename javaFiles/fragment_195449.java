import java.awt.Dimension;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import org.pdfclown.documents.Document;
import org.pdfclown.documents.Page;
import org.pdfclown.documents.contents.composition.BlockComposer;
import org.pdfclown.documents.contents.composition.PrimitiveComposer;
import org.pdfclown.documents.contents.composition.XAlignmentEnum;
import org.pdfclown.documents.contents.composition.YAlignmentEnum;
import org.pdfclown.documents.contents.fonts.Font;
import org.pdfclown.documents.contents.fonts.StandardType1Font;
import org.pdfclown.files.File;
import org.pdfclown.files.SerializationModeEnum;

public class Main {

    private static final int Margin_X = 50;
    private static final int Margin_Y = 50;

    public static void main(String args[])
    {
        try {

            Document document = new File().getDocument();

            Page page = new Page(document);
            document.getPages().add(page); 

            Dimension2D pageSize = page.getSize();

            PrimitiveComposer composer = new PrimitiveComposer(page);

            BlockComposer blockComposer = new BlockComposer(composer);

            composer.beginLocalState();

            Rectangle2D frame = new Rectangle2D.Double(Margin_X, Margin_Y, pageSize.getWidth() - Margin_X * 2, pageSize.getHeight() - Margin_Y * 2);

            blockComposer.begin(frame,XAlignmentEnum.Left,YAlignmentEnum.Top);

            Dimension breakSize = new Dimension(24, 8); // Indentation (24pt)
                                                        // and top margin (8pt).

            composer.setFont(new StandardType1Font(document, StandardType1Font.FamilyEnum.Courier, true, false), 14);

            blockComposer.begin(frame, XAlignmentEnum.Left, YAlignmentEnum.Top);

            blockComposer.showBreak(breakSize);
            blockComposer.showText("There was nothing so VERY remarkable in that; nor did Alice think it so VERY much out of the way to hear the Rabbit say to itself, 'Oh dear! Oh dear! I shall be late!' (when she thought it over afterwards, it occurred to her that she ought to have wondered at this, but at the time it all seemed quite natural); but when the Rabbit actually TOOK A WATCH OUT OF ITS WAISTCOAT- POCKET, and looked at it, and then hurried on, Alice started to her feet, for it flashed across her mind that she had never before seen a rabbit with either a waistcoat-pocket, or a watch to take out of it, and burning with curiosity, she ran across the field after it, and fortunately was just in time to see it pop down a large rabbit-hole under the hedge.");
            blockComposer.showBreak(breakSize);
            blockComposer.showText("Wassup");

            blockComposer.end();

            composer.flush();

            document.getFile().save(job.getUpdateFileLocalDir() + "/pdfclown.pdf" , SerializationModeEnum.Standard);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}