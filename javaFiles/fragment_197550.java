public class Member {
    @Resource
    MemberDao memberDao;

    public String createNewId() {
        return memberDao.findNext().getId();
    }
}