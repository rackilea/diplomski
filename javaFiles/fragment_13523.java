object MySpek: Spek({
    val myMock1 by memoized { mock<myMock1>() }
    val myMock2 by memoized { mock<myMock2>() }

    val handler by memoized { StartModeHandler(myMock1, myMock2) }

    val session by memoized { 
        mock<Session> {
            on { user }.doReturn(User.builder().withUserId("userId").build())
        }
    }

    describe("item exists for user") {
        beforeEachTest {
            reset(digitalPointDao, trackDao)
            whenever(myMock1.loadItem(session.user.userId)).thenReturn(Optional.of(MyItem()))
            whenever(myMock2.loadSomething()).thenReturn(ArrayList())
        }

        // use on instead of context
        on("method onLaunch was called") {
            val response = handler.onLaunch(session)
            it("should return the response for existing user") {
                //some asserts here
            }
            it("should save the item") {
                //some mock verifies here
            }
        }

    }
})