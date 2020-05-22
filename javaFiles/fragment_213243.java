@Test
public void it_should_test_2() throws IOException, ParseException {
    //Given
    String str = "{\n" +
            "    \"access_token\":\"HzDzAtlom6CDqRa0zPetH09hZbDr8tm__hPw7aCx2m0h0gnGwHMaKvBEp64sHRUCJJEAlhCNUqQ3tBSyvod_93gTnt145W2ly9KKw5ISmaZRN75O9NUfJUGPRd0LH87LlxiRgHNFkUGTUDwyJOmhYNajj7TQoncxqkfc3jxL-jEi3Ea1cGRvOSmLH5Aqom81kKmiRzPV_Ss0xwFWjQVsS03y_P720Hv1BQEayO9L7Vic4A64GmXm3PlFQuwcvOk3M_7WOa_EEGOFBZdhwn7dzNQ7gypJ27MSTOD3gI57880unF4XFgTT_H4p4G5V6C8L8yRbRNXPIe80gLKYk3F3nw\",\n" +
            "    \"token_type\":\"bearer\",\n" +
            "    \"expires_in\":3599,\n" +
            "    \"refresh_token\":\"f87a5fea7d764826be24bd742626d0d8\",\n" +
            "    \"as:client_id\":\"paymentApp\",\n" +
            "    \"username\":\"savemore01\",\n" +
            "    \".issued\":\"Wed, 05 Dec 2018 03:13:23 GMT\",\n" +
            "    \".expires\":\"Wed, 05 Dec 2018 04:13:23 GMT\"\n" +
            "}";

    //When
    Response response = new ObjectMapper().readValue(str, Response.class);

    //Then
    assertThat(response.getAccessToken()).isEqualTo("HzDzAtlom6CDqRa0zPetH09hZbDr8tm__hPw7aCx2m0h0gnGwHMaKvBEp64sHRUCJJEAlhCNUqQ3tBSyvod_93gTnt145W2ly9KKw5ISmaZRN75O9NUfJUGPRd0LH87LlxiRgHNFkUGTUDwyJOmhYNajj7TQoncxqkfc3jxL-jEi3Ea1cGRvOSmLH5Aqom81kKmiRzPV_Ss0xwFWjQVsS03y_P720Hv1BQEayO9L7Vic4A64GmXm3PlFQuwcvOk3M_7WOa_EEGOFBZdhwn7dzNQ7gypJ27MSTOD3gI57880unF4XFgTT_H4p4G5V6C8L8yRbRNXPIe80gLKYk3F3nw");
    assertThat(response.getExpiresIn()).isEqualTo(3599L);
    assertThat(response.getTokenType()).isEqualTo("bearer");
    assertThat(response.getRefreshToken()).isEqualTo("f87a5fea7d764826be24bd742626d0d8");
    assertThat(response.getClientId()).isEqualTo("paymentApp");
    assertThat(response.getIssued()).isEqualTo(DateUtils.parseDate("Wed, 05 Dec 2018 03:13:23 GMT", "EEE, dd MMM yyyy HH:mm:ss zzz"));
    assertThat(response.getExpires()).isEqualTo(DateUtils.parseDate("Wed, 05 Dec 2018 04:13:23 GMT", "EEE, dd MMM yyyy HH:mm:ss zzz"));
}