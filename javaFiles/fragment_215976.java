int updateCount = stmt.executeUpdate(query);

if(updateCount > 0) {
    String encodedURL = response.encodeRedirectURL("ShowInventoryList.jsp");
    response.sendRedirect(encodedURL);      
}