public void dcmconvpng(File file, int indice, File fileOutput)
        throws IOException, DicomException {

    ConsumerFormatImageMaker.convertFileToEightBitImage(file.toString(),
            fileOutput.toString(), "png", indice);
}