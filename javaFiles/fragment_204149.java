import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoInsert {

/**
 * @param args
 * @throws Exception 
 */
public static void main(String[] args) throws Exception {


    Encapsulation bean=new Encapsulation();
    // Setting values
    bean.setId("value1");
    bean.setProduct_name("value2");
    bean.setProduct_image("value3");
    bean.setProduct_price("value4");
    bean.setProduct_src("value5");
    bean.setProduct_url("value6");
    bean.setDate("value7");
    bean.setCountry("value8");
    bean.setCategory("value9");

    MongoClient mongo = new MongoClient("localhost", 27017);
    DB db = mongo.getDB("Test");    
    DBCollection coll = db.getCollection("mycol");

    //getting values and assigning to mongo field
    BasicDBObject doc = new BasicDBObject("id", bean.getId()).
                             append("Product_name", bean.getProduct_name()).
                             append("Product_image", bean.getProduct_image()).
                             append("Product_price", bean.getProduct_price()).
                              append("Product_src", bean.getProduct_src()).
                              append("Product_url", bean.getProduct_url()).
                              append("Date", bean.getDate()).
                              append("Country", bean.getCountry()).
                              append("Category", bean.getCategory());                                                                                       

                              coll.insert(doc); 
}
}