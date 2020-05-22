@Unroll
class UserFilterSpec extends Specification {
    static final String USER_ID_1 = "someUserId1"
    static final String USER_ID_2 = "someUserId2"
    static final String USER_ID_3 = "someUserId3"

    @Shared user1 = setupTestUser(USER_ID_1)
    @Shared user2 = setupTestUser(USER_ID_2)
    @Shared user3 = setupTestUser(USER_ID_3)

    @Shared filter = new UserFilter()

    def "given a list of users and list of user ids, should return list of user with those users removed"() {
        expect:
        filter.filterUserDataByIds(userList, userIdList) == filterList

        where:
        userList              | userIdList  || filterList
        [user1, user2, user3] | [USER_ID_1] || [user2, user3]    
    }
}