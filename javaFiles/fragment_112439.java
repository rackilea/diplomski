public class Converter {

       public static void main(String[] args) {

          Map<String, Long> map = new HashMap<>();
          map.put("111", 80L); // first
          map.put("1A9-ppp", 190L); // second
          map.put("98U-6765", 900L); // third
          map.put("999-aa", 95L); // fourth

          List<Response> list = map.entrySet().stream().map(
                ent -> Response.instanceOf(ent.getKey(), ent.getValue())).collect(
                      Collectors.toList());

          System.out.println(list);
       }
    }

    class Response {
       String name;
       String city;
       long   price;

       public Response(String name, String city, long price) {
          this.name = name;
          this.city = city;
          this.price = price;
       }

       public static Response instanceOf(String str, long price) {
          if (str.indexOf("-") == -1) {
             str += "-NoName";
          }
          String[] items = str.split("-");
          return new Response(items[0], items[1], price);
       }

       public String toString() {
          return "name = " + name + ", city = " + city + ", " + "price = " + price;
       }
    }