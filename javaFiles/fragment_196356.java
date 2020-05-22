public Promise<Result> addUserAddress(final String userId) throws Exception {
    Address newAddress = AddressFrom.get();
    Address ua = new Address(user, 
    ThirdPartyApplication.findThirdPartyApplicationById(1));
    ua.save();

    Promise<Optional<Person>> promise = restClient.findPersonByEmail(user.getEmail());

    return promise.flatMap(person -> {
        if (person.isPresent()) {
            return restClient.addAddress(person.get().id, ua).map(address -> {
                ua.thirdPartyAddressId = String.valueOf(address.id);
                ua.thirdPartyUserId = String.valueOf(address.customerId);
                ua.save();

                Logger.info("Sync success.");

                ObjectNode resultNode = Json.newObject();
                resultNode.set("address", Json.toJson(ua));
                return new Dummy(resultNode);
                //return ok("Dummy test");
            });
        }
    });


}