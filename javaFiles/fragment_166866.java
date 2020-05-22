JsonObject jsonObject = new JsonObject();
      jsonObject.addProperty("id", favoriteWrapper.getId());
      jsonObject.addProperty("menuitemid", favoriteWrapper.getMenuItemId());
      jsonObject.addProperty("displayname", favoriteWrapper.getDisplayName());
      jsonObject.addProperty("description", favoriteWrapper.getDescription());
      jsonObject.addProperty("alias", favoriteWrapper.getAlias());

      JsonArray condiments = new JsonArray();
         for (Long condimentId : favoriteWrapper.getCondiments()) {
                condiments.add(new JsonPrimitive(condimentId));
         }

      jsonObject.add("condiments", condiments);
      jsonObjects.add(jsonObject);