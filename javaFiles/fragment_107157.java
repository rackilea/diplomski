.filters{
    it.changeRequestUri {
        val (service, environment, newPath) = computeUrlParts(it)
        Optional.of(URI("http://$environment$service.internal.my-company.com/$newPath"))
    }
}
.uri("http://postman-echo.com") //ignored