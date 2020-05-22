public static void main(String[] args) {

    Person person = new Person("Ali", "a@c.o");
    try {
        System.out.println(getObjectNameValuePairs(person));

    } catch (IllegalArgumentException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

}

public static ArrayList<NameValuePair> getObjectNameValuePairs(Object obj) throws IllegalArgumentException, IllegalAccessException {
    ArrayList<NameValuePair> list = new ArrayList<NameValuePair>();
    for (Field field : obj.getClass().getDeclaredFields()) {
        field.setAccessible(true); // if you want to modify private fields
        NameValuePair nameValuePair = new NameValuePair();
        nameValuePair.setName(field.getName());
        nameValuePair.setValue(field.get(obj));
        list.add(nameValuePair);
    }
    return list;
}