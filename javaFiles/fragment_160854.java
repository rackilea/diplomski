Parse.Cloud.beforeSave(Parse.User, function(request, response) {
    var user = request.object;
    if (!/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/.test(user.get("email"))) {
        response.error("Invalid email.");
    } else if (!user.get("email")) {
        response.error("Every user must have an email address.");
    } else {
        response.success();
    }
});