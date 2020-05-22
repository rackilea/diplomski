<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>
....

<%
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>