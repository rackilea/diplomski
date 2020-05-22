ObjectMapper mapper = new ObjectMapper();

JsonNode accounts = given().when().expect().statusCode(expectedResponseCode)
    .get("accounts/" + newClub.getOwner().getCustId() + "/clubs")
    .as(JsonNode.class);


//Jackson's use of generics here are completely unsafe, but that's another issue
List<Account> accountList = mapper.convertValue(
    accounts, 
    new TypeReference<List<Account>>(){}
);

assertThat(accountList.get(0).getId()).isEqualTo(expectedId);