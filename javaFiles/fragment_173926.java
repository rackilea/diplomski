//Select the <span> element the text "Logname"
    Elements select = mHtml.select(".account-detail span.label:contains(Logname)");

    //Get the element itself, since the select returns a list
    Element lognameSpan = select.get(0);

    //Get the <li> parent of the <span>
    Element parent = lognameSpan.parent();

    //Access the text node of the <li> directly since there is only one
    String logname = parent.textNodes().get(0).text();