String json = "{\n" +
              "  \"batchcomplete\": \"\",\n" +
              "  \"query\": {\n" +
              "    \"pages\": {\n" +
              "      \"23140032\": {\n" +
              "        \"pageid\": 23140032,\n" +
              "        \"ns\": 0,\n" +
              "        \"title\": \"Frodo Baggins\",\n" +
              "        \"extract\": \"Frodo Baggins is a fictional character in J. R. R. Tolkien's legendarium, and the main protagonist of The Lord of the Rings. Frodo is a hobbit of the Shire who inherits the One Ring from his cousin Bilbo Baggins and undertakes the quest to destroy it in the fires of Mount Doom. He is also mentioned in Tolkien's posthumously published works, The Silmarillion and Unfinished Tales.\"\n" +
              "      }\n" +
              "    }\n" +
              "  }\n" +
              "}";
Root root = new Gson().fromJson(json, Root.class);
for (Page page : root.query.pages.values()) {
    System.out.println(page.title);
    System.out.println("  " + page.extract);
}