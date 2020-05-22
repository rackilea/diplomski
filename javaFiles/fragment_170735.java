public static void main(String[] args)
{
    Timestamp t = new Timestamp(System.currentTimeMillis());
    System.out.println(t);
    System.out.println(t.toLocaleString());
    String json = new Gson().toJson(t);
    System.out.println(json);
    json = new GsonBuilder()
               .setDateFormat("yyyy-MM-dd hh:mm:ss.S")
               .create()
               .toJson(t);

    System.out.println(json);
}