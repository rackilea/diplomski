public class Products_data implements Parcelable {
@SerializedName("retailer_id")
private String retailer_id;

@SerializedName("retailer_name")
private String retailer_name;

@SerializedName("product_code")
private String product_code;

@SerializedName("product_name")
private String product_name;

@SerializedName("pro_packing")
private String pro_packing;

@SerializedName("pro_company")
private String pro_company;

@SerializedName("pro_generic_code")
private String pro_generic_code;

@SerializedName("pro_generic_name")
private String pro_generic_name;

@SerializedName("product_stock")
private Integer product_stock;

@SerializedName("product_MRP")
private Double product_MRP;


public Products_data() {
}

protected Products_data(Parcel in) {
    retailer_id = in.readString();
    retailer_name = in.readString();
    product_code = in.readString();
    product_name = in.readString();
    pro_packing = in.readString();
    pro_company = in.readString();
    pro_generic_code = in.readString();
    pro_generic_name = in.readString();
    product_stock = in.readInt();
    product_MRP = in.readDouble();
}

public static final Creator<Products_data> CREATOR = new Creator<Products_data>() {
    @Override
    public Products_data createFromParcel(Parcel in) {
        return new Products_data(in);
    }

    @Override
    public Products_data[] newArray(int size) {
        return new Products_data[size];
    }
};

public String getRetailer_id() {
    return retailer_id;
}

public void setRetailer_id(String retailer_id) {
    this.retailer_id = retailer_id;
}

public String getRetailer_name() {
    return retailer_name;
}

public void setRetailer_name(String retailer_name) {
    this.retailer_name = retailer_name;
}

public String getProduct_code() {
    return product_code;
}

public void setProduct_code(String product_code) {
    this.product_code = product_code;
}

public String getProduct_name() {
    return product_name;
}

public void setProduct_name(String product_name) {
    this.product_name = product_name;
}

public String getPro_packing() {
    return pro_packing;
}

public void setPro_packing(String pro_packing) {
    this.pro_packing = pro_packing;
}

public String getPro_company() {
    return pro_company;
}

public void setPro_company(String pro_company) {
    this.pro_company = pro_company;
}

public String getPro_generic_code() {
    return pro_generic_code;
}

public void setPro_generic_code(String pro_generic_code) {
    this.pro_generic_code = pro_generic_code;
}

public String getPro_generic_name() {
    return pro_generic_name;
}

public void setPro_generic_name(String pro_generic_name) {
    this.pro_generic_name = pro_generic_name;
}

public Integer getProduct_stock() {
    return product_stock;
}

public void setProduct_stock(Integer product_stock) {
    this.product_stock = product_stock;
}

public Double getProduct_MRP() {
    return product_MRP;
}

public void setProduct_MRP(Double product_MRP) {
    this.product_MRP = product_MRP;
}

@Override
public int describeContents() {
    return 0;
}

@Override
public void writeToParcel(Parcel parcel, int i) {
    parcel.writeString(retailer_id);
    parcel.writeString(retailer_name);
    parcel.writeString(product_code);
    parcel.writeString(product_name);
    parcel.writeString(pro_packing);
    parcel.writeString(pro_company);
    parcel.writeString(pro_generic_code);
    parcel.writeString(pro_generic_name);
    parcel.writeInt(product_stock);
    parcel.writeDouble(product_MRP);
}
}