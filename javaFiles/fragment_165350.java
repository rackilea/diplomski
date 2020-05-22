@RequestMapping(value = "/time/{date}", method = RequestMethod.GET)
public ModelRunCollection  getPolicyByDate(
        @PathVariable("date")
        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                DateTime date) {
    return delegate.submit(new GetPolicyByDateRequest(date));
}