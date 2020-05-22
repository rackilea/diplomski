if(contains){
    //you will need to look at how to add this to a switch properly,
    //just giving you an idea of how I'd look at it.
    switch(urlContent.startswith) {
        case TRANSMIT:
            mProcess.onTransmit(activity, url);
        case TAKEORDER:
            mProcess.onTakeOrder(activity, url);
        case GOODS:
            if (urlContent.contains(GOODSMANAGER_MMZL)) {
                mProcess.onEnterpriseShopManage(activity, url);
            } else {
                mProcess.onGoods(activity, url);
            }
        case SUPPLIER:
            mProcess.onSupplier(activity, url);
        case POSTS:
            mProcess.onPosts(activity, url);
        case TEAM:
            if (urlContent.contains(TEAM_LIST)) {
                mProcess.onTeamList(activity);
            } else if (urlContent.contains(TEAMINDEX)) {
                mProcess.onTeamIndex(activity, url);
            } else if (urlContent.contains(TEAMINFO)) {
                mProcess.onTeamInfo(activity, url);
            } else if (urlContent.contains(TEAMMEMBER_INFO)) {
                mProcess.onTeamMemberInfo(activity, url);
            } else {
                mProcess.onTeam(activity, url);
            }
    }
}