@ParameterizedTest
@MethodSource("userInfoProvider")
void testUserInfo(UserInfo argument) {
    // assert something...
}

/*
 * Doesn't necessarily have to be static or return a Stream. Read
 * the documentation to know when the method must be static and
 * what other return types are possible.
 */
static Stream<UserInfo> userInfoProvider() {
    return Stream.of(
        new UserInfo(...),
        new UserInfo(...),
        new UserInfo(...),
        // and so on...
    );
}