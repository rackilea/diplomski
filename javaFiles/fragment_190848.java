/**
 * Retrieves all the topics (backend - admin side)
 *
 * @param jtStartIndex Indicates the first record of paging
 * @param jtPageSize Number of records to show in each page
 * @param topic
 * @param forumId
 * @param status
 * @param search
 * @return an instance of javax.ws.rs.core.Response
 */
@RolesAllowed({AllConstants.USER_ROLE_ADMIN})
@Path("/getTopics")
@GET
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public Response getTopics(@QueryParam("jtStartIndex") int jtStartIndex,
        @QueryParam("jtPageSize") int jtPageSize,
        @QueryParam("topic") String topic,
        @QueryParam("forum") int forumId,
        @QueryParam("state") int status,
        @QueryParam("jtSorting") String jtSorting,
        @QueryParam("search") int search) {
    try {
        EntityManager em = JpaUtils.getEntityManager();

        List<JforumTopic> topicEntities;            

        //Filtering
        if (search == 1) {
            if (topic == null) {
                topic = "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT t FROM JforumTopic t WHERE LOWER(t.topicTitle) LIKE :topicTitle ");

            if (forumId > 0) {
                sb.append(" AND t.forumId = :forumId ");
            }

            if (status > -1) {
                sb.append(" AND t.topicStatus = :topicStatus ");
            }

            Query query = em.createQuery(sb.toString());

            query.setParameter("topicTitle", "%" + topic.toLowerCase() + "%");

            if (forumId > 0) {
                query.setParameter("forumId", forumId);
            }

            if (status > -1) {
                query.setParameter("topicStatus", status);
            }

            topicEntities = query.getResultList();

        } else {
            TypedQuery<JforumTopic> query = em.createNamedQuery("JforumTopic.findAll", JforumTopic.class);
            topicEntities = query.getResultList();              
        }

       //Sorting
        if (jtSorting != null && !jtSorting.isEmpty()) {
            if (jtSorting.equals("relatedId ASC")) {
                Collections.sort(topicEntities, new Comparator<JforumTopic>(){
                    @Override
                    public int compare(JforumTopic top1, JforumTopic top2) {
                        return top1.getRelatedId().compareTo(top2.getRelatedId());
                    }
                });                    
            }                
        if(jtSorting.equals("relatedId DESC")) {
                Collections.sort(topicEntities, new Comparator<JforumTopic>(){
                    @Override
                    public int compare(JforumTopic top1, JforumTopic top2) {
                        return top2.getRelatedId().compareTo(top1.getRelatedId());
                    }
                });
            }          
      if (jtSorting.equals("relatedTitle ASC")) {
                Collections.sort(topicEntities, new Comparator<JforumTopic>(){
                    @Override
                    public int compare(JforumTopic top3, JforumTopic top4) {
                        return top3.getRelatedTitle().compareTo(top4.getRelatedTitle());
                    }
                });                    
            }                
        if(jtSorting.equals("relatedTitle DESC")) {
                Collections.sort(topicEntities, new Comparator<JforumTopic>(){
                    @Override
                    public int compare(JforumTopic top3, JforumTopic top4) {
                        return top4.getRelatedTitle().compareTo(top3.getRelatedTitle());
                          }
                });
            }
        }

     // end of sorting

       //Paging
        PagingHelper<JforumTopic> ph = new PagingHelper<JforumTopic>(jtStartIndex, jtPageSize, topicEntities);
        topicEntities = ph.getSublist();
        String jsonFinal = ph.getJson(topicEntities);
        return Response.status(Response.Status.OK).entity(jsonFinal).build();
    } catch (Exception ex) {
        logger.log(Level.SEVERE, "ForumResource.getTopics() threw exception: ", ex);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}

/**