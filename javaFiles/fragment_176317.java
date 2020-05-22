private List<EditText> mIngrediantEditTexts = new ArrayList<>();
private List<Spinner> mIngrediantSpinners = new ArrayList<>();

public void addRow() {
  ...

  EditText ingrediantEditText = new EditText(this);
  Spinner ingrediantSpinner = new Spinner(this);

  ...

  mIngrediantEditTexts.add(ingrediantEditText);
 mIngrediantSpinners.addd(ingrediantSpinner);

  ...
}