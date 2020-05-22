public Inline createInline(File filePict) throws Exception{
    byte[] bytes = convertImageToByteArray(filePict);
    BinaryPartAbstractImage imagePart = BinaryPartAbstractImage.createImagePart(this.getWordMLPackage(), bytes);
    int id1 = 1;
    int id2 = 2;
    Inline inline = imagePart.createImageInline("Filename hint", filePict.getName(), id1, id2, false);
    return inline;
}