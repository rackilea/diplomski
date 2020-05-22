Element link = div.select("a:not([class])").first();
Elements linksInUniqspan = document.select("span.uniqspan a:not([class])");

if (linksInUniqspan.contains(link)) {
    // Link is inside span.uniqspan.
} else {
    // Link is not inside span.uniqspan.
}