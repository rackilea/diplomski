try
{
    document = PDDocument.load( "C:\\abc.pdf");

    if(document.isEncrypted())
    {
      //Then the pdf file is encrypeted.
    }
}