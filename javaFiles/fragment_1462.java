Matcher<String> matcher =
        allOf(
                is(either(containsString("Login")).or(containsString("Logout"))),
                is(not(allOf(containsString("Login"), containsString("Logout")))));
assertThat("_Login_", matcher); // OK
assertThat("_Logout_", matcher); // OK
assertThat("_Login_Logout_", matcher); // FAIL
assertThat("__", matcher); // FAIL