private int findCityExtensionByName (String cityName)
{
    for(int i=0 ; i<=MAXIMUM_NUMBER_OF_CITIES ;i++)
    {
        if (_cities[i].getCityName().equals(cityName))
            return i;      
    }
    return -1;
}