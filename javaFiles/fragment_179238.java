if (MembershipConfig.PREMIUM_TAG_DISPLAY) {
    switch (player.getClientConnection().getAccount().getMembership()) {
        case 1:
        adminTag = sb.insert(0, MembershipConfig.TAG_PREMIUM.substring(0, 2)).toString();
        break;
    case 2:
        adminTag = sb.insert(0, MembershipConfig.TAG_VIP.substring(0, 2)).toString();
        break;
    }
}
// * = Wedding
if (player.isMarried()) {
    adminTag = sb.insert(0, WeddingsConfig.TAG_WEDDING.substring(0, 2)).toString();
}