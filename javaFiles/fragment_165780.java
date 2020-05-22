@RequestMapping(method = GET, value = "/progress")
@ResponseBody
public Response findAllAndProgress() {
    return Response.status(Response.Status.OK)
        .entity(gameService.findAllAndProgress())
        .header(ACCESS_CONTROL_ALLOW_ORIGIN, "*")
        .build();
}