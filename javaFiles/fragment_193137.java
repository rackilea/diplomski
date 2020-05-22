for (int i = 0; i < jarray.length(); i++) {
                        JSONObject object = jarray.getJSONObject(i);

                        actor = new Actors();

                        actor.setName(object.getString("title"));
                        actor.setDescription(object.getString("excerpt"));
                        actor.setDate(object.getString("date"));
                        actor.setAuthor(object.getString("name"));

                        JSONArray tags = object.getJSONArray("tag");
                        for (int j = 0; j < tags.length(); j++) {
                          // you can access each tag in this section 
                        }

                        JSONArray attachment = object.getJSONArray("attachment");
                        for (int k = 0; k < tags.length(); k++) {
                          // you can access inside attachment 
                        JSONObject insideAttachmentObj = attachment.getJSONObject(k);
                        insideAttachmentObj.getJSONObject("images").getJSONObject("thumbnail");
                        //or for accessing url :insideAttachmentObj.getJSONObject("images").getJSONObject("thumbnail").getString("url");
                        }



                        songList.add(actor);