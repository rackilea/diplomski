public class Product {

    @Required
    public String ean;
    @Required
    public String name;
    public String description;
        public String getEan() {
        return ean;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    } 
}