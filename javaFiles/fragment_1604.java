List<String> friendList = new ArrayList<String>();
friendList.add("friend1");
friendList.add("friend2");

// assert before actually calling the method under test to make sure my setup is ok
assertEquals(2, friendList.size());

// theObj is an instance of the class you are testing
theObj.friendList = friendList; 

// call the method under test
theObj.removeFriend("friend1");

// be explicit, the list should now have size1 and NOT contain the removed friend
assertEquals(1, friendList.size());
assertFalse(friendList.contains("friend1");