class ExtractMovieSaxHandler extends DefaultHandler {

    // These are some parameters for the search which will select 
    // the subtrees (they will receive data when we set up the parser)
    private String tagToMatch;
    private String tagContents; // OR match
    private boolean strict = false;  // if strict matches will be exact

    /**
     * Sets criteria to select and copy Movie elements from source XML.
     *
     * @param tagToMatch Must contain text only
     * @param tagContents Text contents of the tag
     * @param strict If true, match must be exact
     */
    public void setSearchCriteria(String tagToMatch, String tagContents, boolean strict) {
        this.tagToMatch = tagToMatch;
        this.tagContents = tagContents;
        this.strict = strict;
    }

    // These are the temporary values we store as we parse the file
    private String currentElement;
    private StringBuilder contents = null; // if not null we are in Movie tag
    private String currentData;
    List<String> result = new ArrayList<String>(); // store resulting nodes here
    private boolean skip = false;

...