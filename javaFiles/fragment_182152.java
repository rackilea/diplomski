public void DataProviderExample(String user, String pwd, String... links) {

for (String link : links) {
         System.out.println(link);
    }
}

...
DataProviderExample("user1", "password1", "X", "Y", "Z");
DataProviderExample("user2", "password2", "Q");