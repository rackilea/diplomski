given(mockUtil
    .exchange(
        ArgumentMatchers.any(),
        ArgumentMatchers.any(),
        ArgumentMatchers.any(),
        // eq matches to any param of the same generic type
        ArgumentMatchers.eq(new ParameterizedTypeReference<MockOutput>(){})))
.willReturn(ResponseEntity.ok().body(new MockOutput("hello", "success")));