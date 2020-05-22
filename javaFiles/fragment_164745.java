public class AssetResponse {
    private Integer id_asset;
    private Integer id_category;
    private Integer id_brand;
    private String  name;
    private Integer status;
    private String updated_at;

    private AssetRate assetRate;
    private AssetCategory assetCategory;
    private Links links;
    private Self self;
    private AssetBrand assetBrand;
    private HasLinked hasLinked;


    public Integer getId_asset() {
        return id_asset;
    }

    public void setId_asset(Integer id_asset) {
        this.id_asset = id_asset;
    }

    public Integer getId_category() {
        return id_category;
    }

    public void setId_category(Integer id_category) {
        this.id_category = id_category;
    }

    public Integer getId_brand() {
        return id_brand;
    }

    public void setId_brand(Integer id_brand) {
        this.id_brand = id_brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public AssetRate getAssetRate() {
        return assetRate;
    }

    public void setAssetRate(AssetRate assetRate) {
        this.assetRate = assetRate;
    }

    public AssetCategory getAssetCategory() {
        return assetCategory;
    }

    public void setAssetCategory(AssetCategory assetCategory) {
        this.assetCategory = assetCategory;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public AssetBrand getAssetBrand() {
        return assetBrand;
    }

    public void setAssetBrand(AssetBrand assetBrand) {
        this.assetBrand = assetBrand;
    }

    public HasLinked getHasLinked() {
        return hasLinked;
    }

    public void setHasLinked(HasLinked hasLinked) {
        this.hasLinked = hasLinked;
    }
}