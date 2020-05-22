public List searchByIngredient(String target) {
       List<Recipe> result = new ArrayList<Recipe>();
       for (Object ingred : mList) {
          Recipe i = (Recipe) ingred;
          if (i.hasIngredient(target)) {
            // return (List) i;
            //Add candidate Recipe into list
                      result.add(Recipe);
          }
       }
       //return null;
       return result;
     }