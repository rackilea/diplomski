String ruta = txtruta.getText();
Document doc = new Document();

try {
    FileOutputStream archivo = new FileOutputStream(ruta + ".pdf"); //crear archivo con su ruta
    PdfWriter.getInstance(document, archivo);
    doc.open();

    PdfPTable tabla = new PdfPTable(8); //creacion de una tabla de 8 columnas

    tabla.addCell("Celda 1");// addCell() agrega una celda a la tabla, el cambio de fila ocurre automaticamente al llenar la fila
    tabla.addCell("Celda 2");
    tabla.addCell("Celda 3");
    tabla.addCell("Celda 4");
    tabla.addCell("Celda 5");
    tabla.addCell("Celda 6");
    tabla.addCell("Celda 7");
    tabla.addCell("Celda 8");// aca se completa una fila

    doc.add(tabla);

    doc.close();

    JOptionPane.showMessageDialog(null, "PDF creado correctamente");

} catch (Exception e) {
    System.out.println("Error: "+ e);
}