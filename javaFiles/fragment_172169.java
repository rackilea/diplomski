public class Part {
    public String partName, Make, PartNumber, altPartNumber, description;
    public BigDecimal price;
    public int quantity;
    public boolean automotive, marine, industrial;

    public Part(String partName, String Make, String PartNumber,
    String altPartNumber, BigDecimal price, int quantity,
    String description, boolean automotive, boolean marine,
    boolean industrial) {
        this.partName = partName;
        this.Make = Make;
        this.PartNumber = PartNumber;
        this.altPartNumber = altPartNumber;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.automotive = automotive;
        this.marine = marine;
        this.industrial = industrial;
    }
}