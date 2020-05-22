ResponseList<Post> results = facebook.getPosts(searchPost);

                    String userId = "";
                    for (Post post : results) {

                        obj.put("Post Id", post.getId());
                        obj.put("Post message", post.getMessage());
                        obj.put("No of likes on Post", post.getLikes().size());
                        obj.put("Post owner name:", post.getFrom().getName());
                        objArray = new JSONArray();