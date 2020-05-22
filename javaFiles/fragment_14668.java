public class Nokiareviews {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://www.developer.nokia.com/Devices/Device_specifications/Nokia_Asha_308/")
                .timeout(1000 * 1000).get();
        Elements content = doc.select("div.accordeonContainer");
        for (Element spec : content) {
            Elements h2 = spec.select("h2.accordeonTitle");
            System.out.println(h2.text());

            Elements dl = spec.select("dl.clearfix");
            Elements dts = dl.select("dt");
            Elements dds = dl.select("dd");

            Iterator<Element> dtsIterator = dts.iterator();
            Iterator<Element> ddsIterator = dds.iterator();
            while (dtsIterator.hasNext() && ddsIterator.hasNext()) {
                Element dt =  dtsIterator.next();
                Element dd =  ddsIterator.next();
                System.out.println("\t\t" + dt.text() + "\t\t" + dd.text());
            }
        }
    }
}