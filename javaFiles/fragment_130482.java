public class HttpCacheRizze extends CacheControl {


        public static CacheControl minutesSecondesMilliseconds(int min, int sec, int milli){
            HttpCacheRizze cc=new HttpCacheRizze();     
            cc.setMaxAge(min*60+sec+milli/1000);
            cc.setPrivate(true);
            return cc;
        }

        public static EntityTag etag(String tag) {
            EntityTag etag = new EntityTag(DigestUtils.sha256Hex(tag));
            return etag;
        }

        /**
         * 
         * @param req
         * @param tag
         * @param timeout
         * @return response if isUnderCache or null if not
         */
        public static Response getCachedResponseMilliseconds(Request req, String tag,int timeoutMs){
            Response.ResponseBuilder rb=null;
            EntityTag etag = etag(tag);     
            if(req!=null){
                rb = req.evaluatePreconditions(new Date(),etag);
                if (rb != null){

                    return rb.cacheControl(HttpCacheRizze.minutesSecondesMilliseconds(0,0,timeout)).tag(etag).build();
                }
            }
            return null;
        }



        /**
         * 
         * @param status
         * @param entity
         * @param tag
         * @param timeout
         * @return response will be cached
         */
        public static Response getCacheInvalidatedResponse(int status, String entity, String tag, int timeoutMs){

            //if entity is null, force status to 204 (empty)
            if(status==204 || entity==null || entity.compareTo("null")==0 || entity.compareTo("{\"null\"}")==0) {
                status=204;
                entity=null;
            }           

            return Response.status(status).entity(entity)
                    .cacheControl(HttpCacheRizze.minutesSecondesMilliseconds(0, 0, timeoutMs))
                    .tag(etag(tag))
                    .build();
        }

    }