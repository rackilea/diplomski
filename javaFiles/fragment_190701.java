@Test
    public void createNewBlogPost() throws Exception {
        String url = TestHelper.URL + "/blogPost/createNewBlogPost";
        when(postService.createNewBlogPost(Mockito.any(BlogPost.class))).thenReturn(TestHelper.createBlogPostResponse1);
        mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(TestHelper.asJsonString(blogPost1)))
                .andExpect(status().isOk())
                .andReturn();

        verify(postService, times(1)).createNewBlogPost(Mockito.any(BlogPost.class));
        verifyNoMoreInteractions(postService);
    }