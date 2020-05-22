`when`(underlayingApi.post(eq("some/rest/url"),
                               any())).thenAnswer {
        val argument = it.arguments[1]
        val completion = argument as ((rawResult: String?, exception: Exception?) -> Unit)
        completion.invoke("result", null)
    }