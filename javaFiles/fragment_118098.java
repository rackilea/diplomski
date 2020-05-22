public static void main(String[] args)
{
    String response = "blahblah<div class='post-body entry-content' id='post-body-6791062644900393367' itemprop='description articleBody'>\n"
            + "1.1.8"//try "1.1.7", "1.1.9", etc to see that this does work
            + "\n<div style='clear: both;'></div>yaddayadda";//this is just to setup the test: you're obviously getting response from somewhere
    String myVersion = "1.1.8";
    System.out.println("My version: "+myVersion);
    Integer versionOK = isVersionOK(response, myVersion);
    String s;
    if (versionOK != null)
    {
        switch (versionOK)
        {
            case 0:
                s = "equal";
                break;
            case -1:
                s = "greater";
                break;
            default:
                s = "lesser";
        }
        System.out.println("Version is " + s);
    }
    else
        System.out.println("Couldn't detect version!");
}

/**
 *
 * @param response
 * @return 0 if equal, -1 if greater, 1 if lesser, null if not found or
 * anything goes unexpectedly-
 */
static Integer isVersionOK(String response, String myVersion)
{
    String whatToSearchForBefore = "<div class='post-body entry-content' id='post-body-6791062644900393367' itemprop='description articleBody'>\n";
    String whatToSearchForAfter = "\n<div style='clear: both;'></div>";
    if (response != null)
    {
        boolean resp = response.contains(whatToSearchForBefore)&&response.contains(whatToSearchForAfter);
        System.out.println("response does " + (resp ? "" : "not ") + "contain the version number");
        if (resp)
        {
            String whatWeFound = response.substring(response.indexOf(whatToSearchForBefore), response.indexOf(whatToSearchForAfter) + whatToSearchForAfter.length());
            System.out.println("----\n"+whatWeFound+"\n----");
            StringTokenizer st = new StringTokenizer(whatWeFound, "\n");
            st.nextToken();
            String version = st.nextToken();
            System.out.println("Version: " + version);
            return myVersion.compareToIgnoreCase(version);
        }
    }
    return null;
}