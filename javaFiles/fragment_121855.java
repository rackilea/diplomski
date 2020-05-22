public class AutoCompleteList
{
  public String url_template;

  @XStreamImplicit(itemFieldName="autocomplete_item")
  public List<AutocompleteItem> autocomplete_item;
}