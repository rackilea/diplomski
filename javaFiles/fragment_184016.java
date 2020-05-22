class AcroInputTagWorker extends InputTagWorker {

public AcroInputTagWorker(IElementNode element, ProcessorContext context) {
    super(element, context);
    PdfAcroForm.getAcroForm(context.getPdfDocument(), true)
            .addField(PdfFormField.createCheckBox(context.getPdfDocument(), new Rectangle(100, 700, 30, 30), "checkbox", "Off"));
}