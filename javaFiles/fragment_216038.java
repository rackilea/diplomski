class MyCellField implements PdfPCellEvent {
        protected String fieldname;
        public MyCellField(String fieldname) {
            this.fieldname = fieldname;
        }
        public void cellLayout(PdfPCell cell, Rectangle rectangle, PdfContentByte[] canvases) {
            final PdfWriter writer = canvases[0].getPdfWriter();
            final TextField textField = new TextField(writer, rectangle, fieldname);
            try {
                final PdfFormField field = textField.getTextField();
                pdfStamper.addAnnotation(field, 1);
            } catch (final IOException ioe) {
                throw new ExceptionConverter(ioe);
            } catch (final DocumentException de) {
                throw new ExceptionConverter(de);
            }
        }
    }