...

@PUT
@Path("{id:[0-9][0-9]*}")
@Consumes(MediaType.APPLICATION_JSON)
public Response update((@PathParam("id") long id, JSONObject json) {
    Event _event = dao.find(id);

    _event.setTitle(json.optString("title"));
    _event.setFinished(json.optBoolean("finished", _event.getFinished())); // if boolean value is not provided, we don't change it

    dao.update(id, _event);
}

...