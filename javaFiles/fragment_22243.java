String spaceName = "...."
XWikiDocument spaceHomePage = xwiki.getDocument(spaceName +".WebHome", xcontext)
if (xwiki.checkAccess("view", spaceHomePage, xcontext) ) {
    // space home viewable
} else {
    // space home not viewable
}