clickOn("#txtLogin");
        write("user");
        clickOn("#txtPass");
        write("BBccd1234");
        clickOn("#btLogin");
        FxAssert.verifyThat("#serverConnectionError",isEnabled());
        clickOn("#serverConnectionError");