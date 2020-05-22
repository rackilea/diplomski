@OnMessage
    public void message(Session session, String msg){
        try {
            JSONObject obj = new JSONObject(msg);
            if (!obj.has("toUserId")){
                //adding user to the database, so they can access their session ID with their user ID
                WebsocketUser wsu = new WebsocketUser(obj.getLong("userId"), session.getId());
                tx.begin();
                em.persist(wsu);
                tx.commit();
            }else if (obj.has("toUserId")){
                //message to be sent to the user with the specified user ID
                //get session ID from database
                query = em.createQuery("SELECT u FROM WebsocketUser u WHERE u.userId = " + obj.getLong("toUserId"), WebsocketUser.class);
                wsu = (WebsocketUser) query.getSingleResult();
                Set<Session> sessions = session.getOpenSessions();
                for (Iterator<Session> i = sessions.iterator(); i.hasNext();){
                    Session s = i.next();
                    if (s.getId().equals(wsu.getSessionId())){
                        s.getAsyncRemote().sendText(obj.getString("message"));
                        break;
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }