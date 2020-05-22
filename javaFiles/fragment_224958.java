int recipeId = recipesLinkedList.get(position).getId();
                int recipeCount = recipesLinkedList.get(position).getNbFavorite();
                boolean recipeStatus = recipesLinkedList.get(position).isFavorite();

                Intent intent = new Intent(ctx, RecipePagerActivity.class);
                Bundle extras = activity.getIntent().getExtras();
                if (extras == null) extras = new Bundle();  //solution

                extras.putInt("Check_Status", 1);
                extras.putInt(RecipesManager.KEY_ID_RECIPE, recipeId);
                extras.putInt("Recipe_Count", recipeCount);
                extras.putBoolean("Recipe Status", recipeStatus);
                intent.putExtras(extras);