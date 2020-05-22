// * Connect to website
String url = "http://kepler.sos.ca.gov/";
Connection.Response resp = Jsoup.connect(url) //
                                .timeout(30000) //
                                .method(Connection.Method.GET) //
                                .execute();

// * Find the form
Document responseDocument = resp.parse();
Element potentialForm = responseDocument.select("form#aspnetForm").first();
checkElement("form element", potentialForm);
FormElement form = (FormElement) potentialForm;

// * Fill in the form and submit it
// ** Search Type
Element radioButtonListSearchType = form.select("[name$=RadioButtonList_SearchType]").first();
checkElement("search type radio button list", radioButtonListSearchType);
radioButtonListSearchType.attr("checked", "checked");

// ** Name search
Element textBoxNameSearch = form.select("[name$=TextBox_NameSearch]").first();
checkElement("name search text box", textBoxNameSearch);
textBoxNameSearch.val("cali");

// ** Submit the form
Document searchResults = form.submit().cookies(resp.cookies()).post();

// * Extract results (entity numbers in this sample code)
for (Element entityNumber : searchResults.select("table[id$=SearchResults_Corp] > tbody > tr > td:first-of-type:not(td[colspan=5])")) {
    System.out.println(entityNumber.text());
}

public static void checkElement(String name, Element elem) {
    if (elem == null) {
        throw new RuntimeException("Unable to find " + name);
    }
}