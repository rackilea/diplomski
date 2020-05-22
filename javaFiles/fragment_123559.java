Uri baseUri = Contacts.Phones.CONTENT_FILTER_URL;
try {
    Class<?> c = Class.forName("android.provider.ContactsContract$PhoneLookup");
    baseUri = (Uri) c.getField("CONTENT_FILTER_URI").get(baseUri);
} 
    catch (Exception e) {
}