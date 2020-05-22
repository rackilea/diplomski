@Test
public void it_should_test() throws IOException {
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
    Map<String, Object> response = new ObjectMapper().readValue(str, HashMap.class);

    //Then
    assertThat(response.get("access_token")).isEqualTo("HzDzAtlom6CDqRa0zPetH09hZbDr8tm__hPw7aCx2m0h0gnGwHMaKvBEp64sHRUCJJEAlhCNUqQ3tBSyvod_93gTnt145W2ly9KKw5ISmaZRN75O9NUfJUGPRd0LH87LlxiRgHNFkUGTUDwyJOmhYNajj7TQoncxqkfc3jxL-jEi3Ea1cGRvOSmLH5Aqom81kKmiRzPV_Ss0xwFWjQVsS03y_P720Hv1BQEayO9L7Vic4A64GmXm3PlFQuwcvOk3M_7WOa_EEGOFBZdhwn7dzNQ7gypJ27MSTOD3gI57880unF4XFgTT_H4p4G5V6C8L8yRbRNXPIe80gLKYk3F3nw");
    assertThat(response.get("expires_in")).isEqualTo(3599);
    assertThat(response.get("token_type")).isEqualTo("bearer");
    assertThat(response.get("refresh_token")).isEqualTo("f87a5fea7d764826be24bd742626d0d8");
    assertThat(response.get("as:client_id")).isEqualTo("paymentApp");
    assertThat(response.get(".issued")).isEqualTo("Wed, 05 Dec 2018 03:13:23 GMT");
    assertThat(response.get(".expires")).isEqualTo("Wed, 05 Dec 2018 04:13:23 GMT");
}