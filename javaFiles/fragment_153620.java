import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.color.PDGamma;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDCheckbox;

public class MyCheckBox {
    public static void main(String arg[])  throws IOException, COSVisitorException
    {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDPage.PAGE_SIZE_LETTER);
        document.addPage(page);

        PDFont font = PDType1Font.HELVETICA;
        PDResources res = new PDResources();
        String fontName = res.addFont(font);
        String da = "/" + fontName + " 10 Tf 0 0.4 0 rg";


        COSDictionary acroFormDict = new COSDictionary(); 
        acroFormDict.setBoolean(COSName.getPDFName("NeedAppearances"), true);
        acroFormDict.setItem(COSName.FIELDS, new COSArray());
        acroFormDict.setItem(COSName.DA, new COSString(da));

        PDAcroForm acroForm =  new PDAcroForm(document, acroFormDict);
        acroForm.setDefaultResources(res);
        document.getDocumentCatalog().setAcroForm(acroForm);


        float x = 10f;
        float y = page.getMediaBox().getHeight();  
        float yOffset = 15f;
        float yCurrent = y - yOffset;  

        PDGamma colourBlack = new PDGamma();
        PDAppearanceCharacteristicsDictionary fieldAppearance = 
                new PDAppearanceCharacteristicsDictionary(new COSDictionary());
        fieldAppearance.setBorderColour(colourBlack);
        COSArray arr = new COSArray();
        arr.add(new COSFloat(227/255f));
        arr.add(new COSFloat(239/255f));
        arr.add(new COSFloat(1f));
        fieldAppearance.setBackground(new PDGamma(arr));

        COSDictionary cosDict = new COSDictionary();
        COSArray rect = new COSArray();
        rect.add(new COSFloat(x));
        rect.add(new COSFloat(yCurrent));
        rect.add(new COSFloat(x+20));
        rect.add(new COSFloat(yCurrent-20));

        cosDict.setItem(COSName.RECT, rect);
        cosDict.setItem(COSName.FT, COSName.getPDFName("Btn")); // Field Type
        cosDict.setItem(COSName.TYPE, COSName.ANNOT);
        cosDict.setItem(COSName.SUBTYPE, COSName.getPDFName("Widget"));
        cosDict.setItem(COSName.TU, new COSString("Test Checkbox with PDFBox"));
        cosDict.setItem(COSName.T, new COSString("testChk"));
        cosDict.setItem(COSName.DA, new COSString("/F0 10 Tf 0 0.4 0 rg"));
//        cosDict.setInt(COSName.FF, 49152);        //Radio Button Symbol
        cosDict.setInt(COSName.F, 4);
//        cosDict.setInt(COSName.FF, 16384);

        PDCheckbox checkbox = new PDCheckbox(acroForm, cosDict);
        checkbox.setFieldFlags(PDCheckbox.FLAG_READ_ONLY);
        checkbox.setValue("Yes");
//        checkbox.setValue("Off");

        checkbox.getWidget().setAppearanceCharacteristics(fieldAppearance);

        page.getAnnotations().add(checkbox.getWidget());                          
        acroForm.getFields().add(checkbox); 

        yCurrent = yCurrent - 20 - yOffset;

        File file = new File("C:\\pdf\\CheckBoxSample.pdf");
        System.out.println("Sample file saved at : " + file.getAbsolutePath());
        document.save(file);
        document.close();
    }

}