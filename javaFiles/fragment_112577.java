JSONArray inviteList = new JSONArray();
// Then you need to add an object to the array for each `user` that has invited.
// For-loop here maybe?
JSONObject invitee = new JSONObject();
invitee.put("invite_user_id", user);
inviteList,add(invitee); // This will make it into an array with objects, I.E., [ { "invite_user_id": "Steve" } ]