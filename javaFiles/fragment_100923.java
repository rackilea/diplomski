// Set route generator to receive and validate generate route command.
runner.http(builder -> builder
    .server(routeGeneratorServer)
    .receive()
    .post("/v1/missionServices/missionPlanning/generateRoute")
    .accept(ContentType.APPLICATION_JSON.getMimeType())
    .payload(new ClassPathResource("templates/gen-route-command.json")));