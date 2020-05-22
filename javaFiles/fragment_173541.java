PF.Cloud.beforeSave("_User", function(request, response) {
    //Prototype linking
    var user = request.object;
    if (user.get("password").length >= 8) {
        response.success();
    } else {
        response.error("Password too short");
    }
});