for (int i1 = 0; i1 < feedArray1.length(); i1++) {
            JSONObject  attachment = (JSONObject) feedArray1.get(i1);
            JSONObject photo = (JSONObject) attachment.getJSONObject("photo");
            item.setImge(photo);
            item.setProfilePic(photo.getString("photo_75"));
            item.setStatus(photo.getString("text"));
         }