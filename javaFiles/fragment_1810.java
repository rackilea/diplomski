UserListItemHolder userListItemInstance = responseEntity.getBody(); // null
...
Log.i("LoginListService else condition", ""
    + userListItemInstance.getUserListItems());
userListItemInstance.setStatus("false");
return userListItemInstance.getUserListItems();