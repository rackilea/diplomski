Session s=(Session)em.getDelegate();

//Get the URL.
String info=null;
try {
 //The wonderful Hibernate team deprecated connection() before giving an alternative.
 //Feel free to share the love at http://opensource.atlassian.com/projects/hibernate/browse/HHH-2603
 //cf http://opensource.atlassian.com/projects/hibernate/browse/HHH-2603?focusedCommentId=29531&page=com.atlassian.jira.plugin.system.issuetabpanels%3Acomment-tabpanel#action_29531
 info=s.connection().getMetaData().getURL();
} catch (Exception e) {
 throw new RuntimeException(e);
}

//Finish
em.close();

return info;