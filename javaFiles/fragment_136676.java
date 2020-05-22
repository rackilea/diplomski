public class Users {

       @SerializedName("Users")
       @Expose
       public List<User> Users = new ArrayList<User>();
    }


    public class User {

       @SerializedName("name")
       @Expose
       public String name;

       @SerializedName("lon")
       @Expose
       public double lon;

       @SerializedName("lat")
       @Expose
       public double lat;

   }