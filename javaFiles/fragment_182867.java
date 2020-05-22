public class BeanWithList {

    // The member's name can be any. The JR engine is using public getter for extracting field's value
    private List<String> cities;
    private Integer id;

    public BeanWithList(List<String> cities, Integer id) {
        this.cities = cities;
        this.id = id;
    }

    // getter should be public    
    public List<String> getCities() {
        return this.cities;
    }

    public Integer getId() {
        return this.id;
    }
}