Validation<String, AdRequest> validateTrackingRequest(AdRequest request) {
    Validation<String, AdRequest> valid = Validation.valid(request);
    Function<Tracker, Validation<String, AdRequest>> mapper = tracker -> Validation.invalid(...);
    Predicate<Tracker> predicate = tracker -> ...;

    return request.getTracking().stream().filter(predicate).findAny().map(mapper).orElse(valid);
}