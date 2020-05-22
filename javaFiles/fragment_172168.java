public class Part {
    public String partName;

    public Part(String partName, String Make, String PartNumber,
    String altPartNumber, BigDecimal price, int quantity,
    String description, boolean automotive, boolean marine,
    boolean industrial) {
        this.partName = partName;
    }
}