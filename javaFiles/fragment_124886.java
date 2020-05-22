public static class MongoMapper extends
        Mapper<Object, BasicDBObject, Text, BSONWritable> {


    public void map(Object key, BasicDBObject value, Context context)
            throws IOException, InterruptedException {


        //This gives all the documents of the company
        BasicDBObject company = (BasicDBObject) value.get("company");

        // This gets the company name
        name = (String) company.get("name");

        //This gives the phone number 
        phone = (String) company.get("phone");