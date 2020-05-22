import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CityInfoRecords {

    public static void main(String[] args) {
        /* The appplication is started this way so that there
           is no need for static methods or variables.
        */
        new CityInfoRecords().startApp(args);
    }

    // Application Start method.
    private void startApp(String[] args) {
        String ls = System.lineSeparator(); // Not all OS Consoles work well with "\n" 
        String filePath = "qwe.csv";        // Path and file name of the data file.
        Scanner in = new Scanner(System.in);
        // Provide the City Info Field to base search from...
        System.out.println("Enter the Data Field you want to search by:" + ls
                + "[City, CityAscii, Lattitude, Longitude, Country" + ls
                + "ISO2, ISO3, AdminName, Capital, Population, ID]" + ls
                + "Wildcards (? and *) can be used:");
        String searchField = in.nextLine();

        // Provide the Search Criteria to find within the supplied City Info Field.
        System.out.println(ls + "Enter the search criteria you are looking for" + ls
                + "in " + searchField + ". Wildcards (? and *) are permitted:");
        String searchCriteria = in.nextLine();

        // Declare a List Interface of String and fill it 
        // with the call to the readRecord method.
        List<String> cityInfoList = readRecord(filePath, searchField, searchCriteria, 0, "N/A");

        // Display the returned List to console window.
        for (int i = 0; i < cityInfoList.size(); i++) {
            System.out.println(cityInfoList.get(i));
        }
    }

    /**
     * Returns a List Interface of the City Information found based on the supplied 
     * search criteria.<br><br>
     * 
     * @param filePath (String) The full path and file name of the data file to read
     * containing City information.<br>
     * 
     * @param searchField (String) The City Information Field to based the supplied 
     * Search Criteria from. Any City Information Field can be supplied here and 
     * letter case is optional. The wildcard characters (? and *) can also be used 
     * here so that the entire field name does not need to be supplied, for example:
     * <pre>
     *          lat*    for the Latitude field or
     *          *asc*   for the CityAscii field or
     *          iso?    for either the ISO2 or ISO3 fields or simply
     *          City    for the City field.</pre><br>
     * 
     * The <b>?</b> wildcard character specifies any single alphanumeric character, 
     * as in ?an, which locates "ran," "pan", "can", and "ban".<br><br>
     * 
     * The <b>*</b> wildcard character specifies zero or more of any alphanumeric 
     * character, as in corp*, which locates "corp", "corporate", "corporation", 
     * "corporal", and "corpulent".<br> 
     * 
     * @param searchCriteria (String) The search criteria string. This can be any 
     * string you would like to search for within the supplied City Information 
     * Field. By default letter case is ignored during searches therefore the 
     * supplied search criteria string does not need to be letter case specific 
     * however if you want the search to be case specific then set this methods
     * optional ignoreLetterCase parameter to false.<br><br>
     * 
     * Wildcard characters (? and *) can also be used within the Search Criteria 
     * string so as to expand the search to other possibilities, for example if 
     * the "City" field is supplied and a criteria string like: "wash*" is supplied
     * then any city which name starts with "Wash" will have their city information 
     * returned.<br><br>
     * 
     * The <b>?</b> wildcard character specifies any single alphanumeric character, 
     * as in ?an, which locates "ran," "pan", "can", and "ban".<br><br>
     * 
     * The <b>*</b> wildcard character specifies zero or more of any alphanumeric 
     * character, as in corp*, which locates "corp", "corporate", "corporation", 
     * "corporal", and "corpulent".<br> 
     * 
     * @param numberOfFoundToReturn (int) The number of cities who's information 
     * should be returned. If 0 is supplied then all cities found will be returned.<br>
     * 
     * @param noDataReplacement (String) Sometimes there is no data supplied for a 
     * specific field within the data file or the file data line may not contain 
     * the same amount of delimited data. Rather than returning NULL or Null String 
     * ("") for empty data fields you can supply here what to actually return in 
     * such a case. "N/A" is a good choice or perhaps: "Nothing Supplied". Whatever 
     * you like to use can be supplied here.<br>
     * 
     * @param ignoreLetterCase (Optional - Boolean - Default is true) By default 
     * searches ignore letter case but if you want your search to be letter case 
     * specific then you can supply boolean false to this optional parameter.<br>
     * 
     * @return (String List Collection) Information for every City found within the 
     * supplied data file which matches the supplied field and search criteria.
     */
    public List<String> readRecord(String filePath, String searchField,
                            String searchCriteria, int numberOfFoundToReturn, 
                            String noDataReplacement, boolean... ignoreLetterCase) {
        String ls = System.lineSeparator(); // Not all OS Consoles work well with "\n" (property)
        boolean ignoreCase = true;          // Ignore letter case when searching (Default - property)
        if (ignoreLetterCase.length > 0) {
            ignoreCase = ignoreLetterCase[0];
        }
        boolean found = false;              // Flag to indicate data was found (toggles)
        int foundCounter = 0;               // Indicates number of same data found (increments)

        List<String> returnableList = // The List of found city information that will be returned (collection)
                new ArrayList<>();

        // City Information Variables (data fields)
        String city;
        String cityAscii;
        String latitude;
        String longitude;
        String country;
        String iso2;
        String iso3;
        String adminName;
        String capital;
        String population;
        String id;

        // Open Scanner to read data file...
        // Try With Resources is used here to auto close the reader.
        try (Scanner fileReader = new Scanner(new File(filePath))) {
            // Iterate through data file...
            while (fileReader.hasNextLine()) {
                // Read file line by line and remove leading or 
                // trailing whitespaces, tabs, line breaks, etc.
                String cityData = fileReader.nextLine().trim();
                // Skip blank or comment lines (comment lines can be lines that start with # or ;)
                if (cityData.equals("") || cityData.startsWith("#") || cityData.startsWith(";")) {
                    continue;   // Get next file line
                }
                // Split the read line based on any comma delimited anomaly.
                String[] cityInfo = cityData.split(",|,\\s+|\\s+,|\\s+,\\s+");
                // The number of data pieces split from data line.
                // Not all lines may contain the same amount of data.
                int i = cityInfo.length;
                /* Ternary is used to fill city information variables
                   so that data not provided will not be null or null string.
                   As an Example for the city variabel this is the same as:
                        if (i >= 1 && !cityInfo[0].equals("")) {
                            city = cityInfo[0].trim();
                        }
                        else {
                            city = noDataReplacement;
                        }
                 */
                city = (i >= 1 && !cityInfo[0].equals("")) ? cityInfo[0].trim() : noDataReplacement;
                cityAscii = (i >= 2 && !cityInfo[1].equals("")) ? cityInfo[1].trim() : noDataReplacement;
                latitude = (i >= 3 && !cityInfo[2].equals("")) ? cityInfo[2].trim() : noDataReplacement;
                longitude = (i >= 4 && !cityInfo[3].equals("")) ? cityInfo[3].trim() : noDataReplacement;
                country = (i >= 5 && !cityInfo[4].equals("")) ? cityInfo[4].trim() : noDataReplacement;
                iso2 = (i >= 6 && !cityInfo[5].equals("")) ? cityInfo[5].trim() : noDataReplacement;
                iso3 = (i >= 7 && !cityInfo[6].equals("")) ? cityInfo[6].trim() : noDataReplacement;
                adminName = (i >= 8 && !cityInfo[7].equals("")) ? cityInfo[7].trim() : noDataReplacement;
                capital = (i >= 9 && !cityInfo[8].equals("")) ? cityInfo[8].trim() : noDataReplacement;
                population = (i >= 10 && !cityInfo[9].equals("")) ? cityInfo[9].trim() : noDataReplacement;
                id = (i >= 11 && !cityInfo[10].equals("")) ? cityInfo[10].trim() : noDataReplacement;

                // Determine the city data field we want to search in
                String regex;
                // Were wildcards used in the supplied Search Field string?
                if (searchField.contains("?") || searchField.contains("*")) {
                    // Yes... Prep regex to get proper search field
                    regex = searchField.replace("?", ".?").replace("*", ".*?").toLowerCase();
                }
                else {
                    regex = "(?i)(" + searchField + ")";
                }

                // Get proper search field data
                String field = "";
                if ("city".toLowerCase().matches(regex)) {
                    field = city;
                }
                else if ("cityAsciis".toLowerCase().matches(regex)) {
                    field = cityAscii;
                }
                else if ("lattitude".toLowerCase().matches(regex)) {
                    field = latitude;
                }
                else if ("longitude".toLowerCase().matches(regex)) {
                    field = longitude;
                }
                else if ("country".toLowerCase().matches(regex)) {
                    field = country;
                }
                else if ("iso2".toLowerCase().matches(regex)) {
                    field = iso2;
                }
                else if ("iso3".toLowerCase().matches(regex)) {
                    field = iso3;
                }
                else if ("adminName".toLowerCase().matches(regex)) {
                    field = adminName;
                }
                else if ("capital".toLowerCase().matches(regex)) {
                    field = capital;
                }
                else if ("population".toLowerCase().matches(regex)) {
                    field = population;
                }
                else if ("id".toLowerCase().matches(regex)) {
                    field = id;
                }
                if (field.equals("")) {
                    System.err.println("Invalid Search Field Name Provided! (" + searchField + ")");
                    return returnableList;
                }

                // See if the search criteria contains wildcard characters
                // A search can be carried out using wildcards in this method.
                if (searchCriteria.contains("?") || searchCriteria.contains("*")) {
                    // There is...build the required Regular Expression (RegEx) to use.
                    regex = searchCriteria.replace("?", ".?").replace("*", ".*?");
                    // See if the data item matches the search criteria ignoring letter case if desired.
                    // The String.matches() method is used for this and ternary for ignoring letter case.
                    if (ignoreCase ? field.toLowerCase().matches(regex.toLowerCase()) : field.matches(regex)) {
                        found = true;   // toogle flag to true if there is a match.
                    }
                }
                // No wildcard characters in search criteria...
                // Ternary is used in condition to handle ignore letter case if desired.
                else if (ignoreCase ? field.equalsIgnoreCase(searchCriteria) : field.equals(searchCriteria)) {
                    found = true;   // toogle flag to true if there is a match.
                }
                // If the 'found' flag has been set to true...
                if (found) {
                    // Add City information to returnable ArrayList
                    String info = ls + "The following details are of city: " + city + ls
                            + "The Ascii string would be: " + cityAscii + ls
                            + "It has the approximate Lattitude of: " + latitude + ls
                            + "And the approximate Longitude of: " + longitude + ls
                            + "It is situated in the country of: " + country + ls
                            + "The city has iso codes like: " + iso2 + " and: " + iso3 + ls
                            + "The State/Province/Region is: " + adminName + ls
                            + "Capital of this city is: " + capital + ls
                            + // Didn't know cities had capitals
                            "The population is approximately: " + population + ls
                            + "City general ZIP code is: " + id;
                    returnableList.add(info);   // Add to list
                    found = false;              // Toggle found flag back to false in prep to locate more city data.
                    foundCounter++;             // increment the found counter.

                    // If the First Instance Only flag is true then...
                    if (numberOfFoundToReturn > 0 && foundCounter == numberOfFoundToReturn) {
                        // Break out of the 'while' loop. We don't need anymore cities.
                        break;
                    }
                }
            }

            // If the Found Counter was not incremented then
            // we didn't find any data in file... Inform User.
            if (foundCounter == 0) {
                System.err.print(ls + "Can not find City Name (" + searchCriteria
                        + ") in data file!" + ls);
            }
        }
        catch (FileNotFoundException ex) {
            System.err.print("City Data file not found! (" + filePath + ")" + ls);
        }

        // Return the List of found data.
        return returnableList;
    }
}