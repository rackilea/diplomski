import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"taskid", "name", "parentCategory"})
public class ParentCategory implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @JsonProperty("taskid")
    private String taskid;
    @JsonProperty("name")
    private String name;
    @JsonProperty("parentCategory")
    private ParentCategory parentCategory;
    public String getTaskid() {
        return taskid;
    }
    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ParentCategory getParentCategory() {
        return parentCategory;
    }
    public void setParentCategory(ParentCategory parentCategory) {
        this.parentCategory = parentCategory;
    }


}


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"taskid", "name", "parentCategory"})
public class Category implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @JsonProperty("taskid")
    private String taskid;
    @JsonProperty("name")
    private String name;
    @JsonProperty("parentCategory")
    private ParentCategory parentCategory;

    public String getTaskid() {
        return taskid;
    }
    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ParentCategory getParentCategory() {
        return parentCategory;
    }
    public void setParentCategory(ParentCategory parentCategory) {
        this.parentCategory = parentCategory;
    }



}


public class Test {


    public static void main(String[] args) throws JsonProcessingException {


         Category category = new Category();
         category.setName("Sunglasses");
         category.setTaskid("79720");

         List<Category> categoryList = new ArrayList<Category>();

         List<ParentCategory> parentCategoryList = new ArrayList<ParentCategory>();
         List<ParentCategory> parentCategoryList2 = new ArrayList<ParentCategory>();

         ParentCategory  parentCategory1 = new ParentCategory(); 
         parentCategory1.setName("Sunglasses & Fashion Eyewear");
         parentCategory1.setTaskid("394");

         ParentCategory  parentCategory2 = new ParentCategory(); 
         parentCategory2.setName("Men's Accessories");
         parentCategory2.setTaskid("2340");

         ParentCategory  parentCategory3 = new ParentCategory(); 
         parentCategory3.setName("Clothing, Shoes & Accessories");
         parentCategory3.setTaskid("10987");

         parentCategory1.setParentCategory(parentCategory2);
         parentCategory2.setParentCategory(parentCategory3);
         category.setParentCategory(parentCategory1);

        ObjectMapper objectMapper = new ObjectMapper();

        String testJson = objectMapper.writeValueAsString(category);
        System.out.println(testJson);
    }

}