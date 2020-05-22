private static String setNonHTML(String txt)
    {
        System.out.println(txt.substring(txt.indexOf("<p style=\"padding-left:") + 23, txt.indexOf("px\"><b>")));
        //return "";

        //grab the padding text indexes
        int beforePaddingIndex = txt.indexOf("<p style=\"padding-left:");
        int afterPaddingIndex = txt.indexOf("px\"><b>");


        //replace all breaks with new lines
        txt = txt.replaceAll("<br>", "\n");

        //replaces all instances of 40px\"> with \n\t  
        txt = txt.replaceAll(txt.substring(beforePaddingIndex, afterPaddingIndex + 7), "\n" + repeat("\t", Integer.parseInt(txt.substring(beforePaddingIndex + 23, afterPaddingIndex)) / 40));

        //the indexes of these items have changed because the last operation replaced them. The following items will not have indexes due to the replace operation.
        beforePaddingIndex = txt.indexOf("<p style=\"padding-left:");
        afterPaddingIndex = txt.indexOf("px\"><b>");
        afterPaddingBeforeBoldIndex = txt.indexOf("px\">");

        //replace a substring of the same tag a second time? should find nothing
        txt = txt.replaceAll(txt.substring(beforePaddingIndex, afterPaddingIndex), "\n" + repeat("\t", Integer.parseInt(txt.substring(beforePaddingIndex + 23, afterPaddingBeforeBoldIndex)) / 40));

        txt = txt.replaceAll("(?s)<[^>]*>(\\s*<[^>]*>)*", "\n");

        return txt;
    }