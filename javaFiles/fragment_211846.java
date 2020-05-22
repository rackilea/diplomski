if(key.getValidSeconds() == 0) {
    //Never Expiring Key
} else if(Instant.now().isAfter(key.getCreationTime().toInstant().plusSeconds(key.getValidSeconds()))) {
    //Expired Key
} else {
    //Valid Key (has not expired yet)
}