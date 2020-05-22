@GET
    @Path("/CacheService/{userId}")
    public Response invokeCacheService(@PathParam("id") String userId, @Context Request req){

            //the key of a good cache control technique, is to : be quick in order to determine if present or not in cache, 
            //and to try to avoid the maximum data processing in order to retrieve fromthe cache (example avoid performing getPlaylistSong  under cache
           int TTL_CACHE_SONGS=10000; //in ms
           String tag =  "CacheService"+userid";

           //is under cache ?
           Response r = HttpCacheRizze.getCachedResponseMilliseconds(req, tag, TTL_CACHE_SONGS);
           if(r!=null){
                // under cache
                return r;
           }

           // cache is not present or need to be refreshed

            ArrayList songList = new ArrayList(); 
            songList = UserService.getPlaylistSongs(userId);
            int status = 200;

            //catch here errors .... empty....
            if(songList==null || songList.size()==0 )
                status = 204;

            r = HttpCacheRizze.getCacheInvalidatedResponse(status, new Gson().toJson(songList), tag, TTL_CACHE_SONGS);

            return r;

    }