public class Device implements java.io.Serializable {
    ...
    private Vendor vendor;
    ...

    @ManyToOne
    @JoinColumn(name="vendor_id", nullable=false)
    public int getVendorId() {
        return this.vendorId;
    }
}