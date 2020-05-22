User oldUser = userService.findUserById(userId);

if (oldUser.infoIsTheSame(userInfo)) {
    return;
}

em.detach(oldUser); 
User updatedUser = userService.addUserInfo(userId, userInfo);      
feedService.addFeed(FeedAction.INFO_UPDATE, oldUser, updatedUser);