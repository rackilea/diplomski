public class IngredientAdapter extends ArrayAdapter<Ingredient> {
    public IngredientAdapter(Context context, ArrayList<Ingredient> ingredients) {
       super(context, 0, ingredients);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // Get the data item for this position
       Ingredient ingredient = getItem(position);    
       // Check if an existing view is being reused, otherwise inflate the view
       if (convertView == null) {
          convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_ingredient, parent, false);
       }
       // Lookup view for data population
       TextView ingredientName = (TextView) convertView.findViewById(R.id.ingredientName);
       TextView ingredientAmt = (TextView) convertView.findViewById(R.id.ingredientAmt);
       // Populate the data into the template view using the data object
       ingredientName.setText(ingredient.name);
       ingredientAmt.setText(ingredient.amt);
       // Return the completed view to render on screen
       return convertView;
   }
}