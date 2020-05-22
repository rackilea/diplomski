for (int i = 0; i < NoUber_cities.size(); i++)
{

    if ((NoUber_cities.get(i)).equalsIgnoreCase("Greenville, SC")
        || (NoUber_cities.get(i)).equalsIgnoreCase("Pensacola, FL")
        || (NoUber_cities.get(i)).equalsIgnoreCase("Peoria, IL")
        || (NoUber_cities.get(i)).equalsIgnoreCase("Asheville, NC")
        || (NoUber_cities.get(i)).equalsIgnoreCase("Hattiesburg, MS")
        || (NoUber_cities.get(i)).equalsIgnoreCase("Portland, ME")
        || (NoUber_cities.get(i)).equalsIgnoreCase("Portland, ME")
        || (NoUber_cities.get(i)).equalsIgnoreCase("Huntsville, AL")
        || (NoUber_cities.get(i)).equalsIgnoreCase("Reading, PA")
        || (NoUber_cities.get(i)).equalsIgnoreCase("Birmingham, AL")
        || (NoUber_cities.get(i)).equalsIgnoreCase("Bloomington, IN")
        || (NoUber_cities.get(i)).equalsIgnoreCase("Bowling Green, KY")
        || (NoUber_cities.get(i)).equalsIgnoreCase("Lafayette, LA")
        || (NoUber_cities.get(i)).equalsIgnoreCase("Central Atlantic Coast, FL")
        || (NoUber_cities.get(i)).equalsIgnoreCase("Lancaster, PA")
        || (NoUber_cities.get(i)).equalsIgnoreCase("Charleston, SC")
        || (NoUber_cities.get(i)).equalsIgnoreCase("Charleston, WV")
        || (NoUber_cities.get(i)).equalsIgnoreCase("San Juan, PR")
        || (NoUber_cities.get(i)).equalsIgnoreCase("London, Ont")
        || (NoUber_cities.get(i)).equalsIgnoreCase("Springfield, IL")
        || (NoUber_cities.get(i)).equalsIgnoreCase("Columbia, MO")
        || (NoUber_cities.get(i)).equalsIgnoreCase("Columbia, SC")
        || (NoUber_cities.get(i)).equalsIgnoreCase("Montgomery, AL")
        || (NoUber_cities.get(i)).equalsIgnoreCase("Morgantown, WV")
        || (NoUber_cities.get(i)).equalsIgnoreCase("Fayetteville, AR")
        || (NoUber_cities.get(i)).equalsIgnoreCase("Wilmington, NC")
        || (NoUber_cities.get(i)).equalsIgnoreCase("Outer Banks, NC"))
    {
        NoUber_cities.remove(i);
        i--;
    }
}