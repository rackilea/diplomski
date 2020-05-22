public final class MyScreen extends MainScreen
{
    KeywordFilterField _keywordFilterField;  
    CountryList _countryList;
public MyScreen(){
 _countryList = new CountryList();
        _countryList.addElement(new Country("Zimbabwe"));
        _countryList.addElement(new Country("Argentina"));
        _countryList.addElement(new Country("Brazil"));
        _countryList.addElement(new Country("Canada"));
        _countryList.addElement(new Country("Chile"));
        _countryList.addElement(new Country("China"));
        _countryList.addElement(new Country("Germany"));

        _keywordFilterField = new KeywordFilterField(){
             protected boolean navigationClick(int status, int time) {
                 int index = getSelectedIndex();

                 String str = (((Country) getElementAt(index)).toString());
                 Dialog.alert(str);

                return true;
             }
        };
        _keywordFilterField.setLabel("");
        _keywordFilterField.setSourceList(_countryList, _countryList);
        add(_keywordFilterField);

}

}

class CountryList extends SortedReadableList implements KeywordProvider
{
    public CountryList()
    {
        super(new CountryListComparator());      
    }

    void addElement(Object element)
    {
        doAdd(element);      
    }

    public String[] getKeywords(Object element)
    {
        if(element instanceof Country)
        {
            return StringUtilities.stringToWords(element.toString());
        }
        return null;
    }

    final static class CountryListComparator implements Comparator
    {
        public int compare(Object o1, Object o2)
        {
            if (o1 == null || o2 == null)
                throw new IllegalArgumentException("Cannot compare null countries");

            return o1.toString().compareTo(o2.toString());
        }
    }

}

class Country
{
    private String _countryName;

    public Country(String countryName)
    {
        _countryName = countryName;      
    }

    public String toString()
    {
        return _countryName;
    }

}