String sourceUrl = "http://www.example.com/mysite/whatever/somefolder/bar/unsecure!+?#whätyöühäv€it/site.html"; // your current site
    String targetUrl = "http://www.example.com/mysite/whatever/otherfolder/other.html"; // the link target
    String expectedTarget = "../../../otherfolder/other.html";
    String[] sourceElements = sourceUrl.split("/");
    String[] targetElements = targetUrl.split("/"); // keep in mind that the arrays are of different length!
    StringBuilder uniquePart = new StringBuilder();
    StringBuilder relativePart = new StringBuilder();
    boolean stillSame = true;
    for(int ii = 0; ii < sourceElements.length || ii < targetElements.length; ii++) {
        if(ii < targetElements.length && ii < sourceElements.length && 
                stillSame && sourceElements[ii].equals(targetElements[ii]) && stillSame) continue;
        stillSame = false;
        if(targetElements.length > ii)
          uniquePart.append("/").append(targetElements[ii]);
        if(sourceElements.length > ii +1)
            relativePart.append("../");
    }

    String result = relativePart.toString().substring(0, relativePart.length() -1) + uniquePart.toString();
    System.out.println("result: " + result);