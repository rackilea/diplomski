public interface TwitterFollowersService {
    /**
     * This method id used to get the List of TWITTER FOLLOWERS.
     *
     * @param userId Get UserId after login and pass it here
     * @param var    Send Current user screen name
     * @param var1   Weather to skip status accept TRUE/FALSE
     * @param var2   Weather to include Entities accept TRUE/FALSE
     * @param var3   Count to get number of response
     * @return Call object of type FOLLOWERS.
     */
    @GET("/1.1/followers/list.json")
    Call<Response> show(@Query("user_id") Long userId, @Query("screen_name") String
            var, @Query("skip_status") Boolean var1, @Query("include_user_entities") Boolean
                                var2, @Query("count") Integer var3);

}