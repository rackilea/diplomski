@POST
@Consumes("application/json")
public Response post(MyObject obj) {}

$.ajax({
    url: url,
    contentType: "application/json",
    data: JSON.stringify(obj)
});