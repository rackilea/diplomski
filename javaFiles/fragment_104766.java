public class Product {
     private Set<Category> categories = new HashSet<Category>();
     //implement hashCode and equals, potentially by id for extra performance
}

public class Category {
     private Set<Product> contents = new HashSet<Product>();
     //implement hashCode and equals, potentially by id for extra performance
}