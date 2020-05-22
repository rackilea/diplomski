// read the image to the stream
final FileInputStream stream =
        new FileInputStream( imagePath );
final CreationHelper helper = workbook.getCreationHelper();
final Drawing drawing = sheet.createDrawingPatriarch();

final ClientAnchor anchor = helper.createClientAnchor();
anchor.setAnchorType( ClientAnchor.MOVE_AND_RESIZE );


final int pictureIndex =
        workbook.addPicture(IOUtils.toByteArray(stream), Workbook.PICTURE_TYPE_PNG);


anchor.setCol1( 0 );
anchor.setRow1( LOGO_ROW ); // same row is okay
anchor.setRow2( LOGO_ROW );
anchor.setCol2( 1 );
final Picture pict = drawing.createPicture( anchor, pictureIndex );
pict.resize();