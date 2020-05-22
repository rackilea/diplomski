@RequestMapping("/api/users/{userId}/favorites/{favoriteId}")
public String clientsByGym(@PathVariable("userId") String userId, @PathVariable("favoriteId") Long favoriteId) {
    Integer theUserId = null;
    if("me".equals(userId)) {
        theUserId = AccessControlUtil.getUserId()
    } else {
        theUserId = Integer.valueOf(userId);
    }
    ...
}