public void protectUserPage(String userName, String userRights, XWikiDocument doc, XWikiContext context)
    throws XWikiException
{
    DocumentReference rightClassReference = getRightsClass(context).getDocumentReference();

    EntityReference relativeRightClassReference =
        rightClassReference.removeParent(rightClassReference.getWikiReference());

    // Allow users to edit their own profiles
    BaseObject newuserrightsobject = doc.newXObject(relativeRightClassReference, context);
    newuserrightsobject.setLargeStringValue("users", userName);
    newuserrightsobject.setStringValue("levels", userRights);
    newuserrightsobject.setIntValue("allow", 1);
}