package model;

public class Person {
    private String name;
    private Map<String, List<String>> contacts;

    // need constructors and other methods.  This one is key
    public void addPhone(String url, String phone) {
        List<String> phones = (this.contacts.contains(url) ? this.contacts.get(url) : new ArrayList<String>());
        phones.add(phone);
        this.contacts.put(url, phones);
    }
}