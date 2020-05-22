if (wasSuccessful) {
    errorList.put(tempName,
                  Collections.singletonMap("upl", new ArrayList<>(successList)));
} else {
    errorList.put(tempName,
                  Collections.singletonMap("upl", new ArrayList<>(failureList)));
}