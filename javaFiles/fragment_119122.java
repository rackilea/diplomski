public static void create() {
    Something something = new Something();
    something.save();
    response.status = StatusCode.CREATED;
    renderTemplate("Application/show.html", something);
}