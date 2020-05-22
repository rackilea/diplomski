MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", java.nio.charset.Charset.forName("UTF-8"));
MockHttpServletRequestBuilder request = post("/myPostPath");
request.content(json);
request.locale(Locale.JAPANESE);
request.accept(MEDIA_TYPE_JSON_UTF8);
request.contentType(MEDIA_TYPE_JSON_UTF8);
mockMvc.perform(request)
    .andDo(print())
    .andExpect(status().isOk());