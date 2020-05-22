public class MediaTest {

    public static void main(String[] args) {
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(
                DocFlavor.SERVICE_FORMATTED.PRINTABLE, null);
        for (PrintService printService : printServices) {
            System.out.println(printService.getName());
            Media[] supportedMedia = (Media[]) printService.getSupportedAttributeValues(
                    Media.class, DocFlavor.SERVICE_FORMATTED.PRINTABLE, null);
            for (Media media : supportedMedia) {
                if (media instanceof MediaSizeName) {
                    handleMediaSizeName((MediaSizeName) media);
                }
            }
        }
    }

    private static void handleMediaSizeName(MediaSizeName mediaSizeName) {
        StringBuilder builder = new StringBuilder("    " + mediaSizeName.toString());
        MediaSize mediaSize = MediaSize.getMediaSizeForName(mediaSizeName);
        if (mediaSize != null) {
            float[] size = mediaSize.getSize(MediaSize.MM);
            builder.append(" - ").append(size[0]).append("x").append(size[1]).append("mm");
        }
        System.out.println(builder.toString());
    }

}