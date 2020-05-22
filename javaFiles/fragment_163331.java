Card jsonbCard = new Card();
    jsonbCard.name = "JSON-B";
    jsonbCard.value = 9001;
    Card gsonCard = new Card();
    gsonCard.name = "GSON";
    gsonCard.value = -9001;

    List<Card> cardList = new ArrayList<>();
    cardList.add(jsonbCard);
    cardList.add(gsonCard);

    Jsonb jsonb = JsonbBuilder.create();
    String listSerialized = jsonb.toJson(cardList);
    System.out.println(listSerialized);

    List<Card> cardListFromJson = jsonb.fromJson(listSerialized, new ArrayList<Card>(){}.getClass().getGenericSuperclass());

    Gson gson = new Gson();  
    List<Card> cardListFromJson_GSON = gson.fromJson(listSerialized,  new TypeToken<List<Card>>(){}.getType());