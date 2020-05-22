Locale currentLocale = new Locale(language, country);

  ResourceBundle messages =
    ResourceBundle.getBundle("resource.MessagesBundle",currentLocale);

  System.out.println(messages.getString("greetings"));
  System.out.println(messages.getString("inquiry"));
  System.out.println(messages.getString("farewell"));