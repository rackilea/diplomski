public class DataList{

@SerializedName("featured")
private List<FeaturedItem> featured;
@SerializedName("products")
private List<ProductsItem> products;
@SerializedName("categories")
private List<CategoriesItem> categories;
@SerializedName("collections")
private List<CollectionsItem> collections;
@SerializedName("shops")
private List<ShopsItem> shops;

@SerializedName("type")
private String type;

@SerializedName("title")
private String title;

public List<FeaturedItem> getFeatured() {
    return featured;
}

public void setFeatured(List<FeaturedItem> featured) {
    this.featured = featured;
}

public List<ProductsItem> getProducts() {
    return products;
}

public void setProducts(List<ProductsItem> products) {
    this.products = products;
}

public List<CategoriesItem> getCategories() {
    return categories;
}

public void setCategories(List<CategoriesItem> categories) {
    this.categories = categories;
}

public List<CollectionsItem> getCollections() {
    return collections;
}

public void setCollections(List<CollectionsItem> collections) {
    this.collections = collections;
}

public List<ShopsItem> getShops() {
    return shops;
}

public void setShops(List<ShopsItem> shops) {
    this.shops = shops;
}

public void setType(String type){
    this.type = type;
}

public String getType(){
    return type;
}

public void setTitle(String title){
    this.title = title;
}

public String getTitle(){
    return title;
}

@Override
public String toString(){
    if(type.equals("featured")){
        return
                "Featured Olanlar{" +
                        "featured = '" + featured + '\'' +
                        ",type = '" + type + '\'' +
                        ",title = '" + title + '\'' +
                        "}";
    }
    else if(type.equals("new_products")){
        return
                "En Yeni Ürünler{" +
                        "products = '" + products + '\'' +
                        ",type = '" + type + '\'' +
                        ",title = '" + title + '\'' +
                        "}";
    }
    else if(type.equals("categories")){
        return
                "Kategoriler{" +
                        "categories = '" + categories + '\'' +
                        ",type = '" + type + '\'' +
                        ",title = '" + title + '\'' +
                        "}";
    }
    else if(type.equals("collections")){
        return
                "Koleksiyonlar{" +
                        "collections = '" + collections + '\'' +
                        ",type = '" + type + '\'' +
                        ",title = '" + title + '\'' +
                        "}";
    }
    else if(type.equals("editor_shops")){
        return
                "Editör Seçimi Vitrinler{" +
                        "shops = '" + shops + '\'' +
                        ",type = '" + type + '\'' +
                        ",title = '" + title + '\'' +
                        "}";
    }
    else if(type.equals("new_shops")){
        return
                "En Yeni Vitrinler{" +
                        "shops = '" + shops + '\'' +
                        ",type = '" + type + '\'' +
                        ",title = '" + title + '\'' +
                        "}";
    }
    return null;
    }  
        }