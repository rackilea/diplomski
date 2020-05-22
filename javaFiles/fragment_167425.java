Parse.Cloud.define("sendPushToNearbyAndMatching", function(request, response) {
    Parse.Cloud.useMasterKey();

    // the authenticated user on the device calling this function
    var user = request.user; 

    // the complex query matching users
    var query = new Parse.Query(Parse.User);
    query.whereNotEqualTo("objectId", user.id);
    // users with Gender = currentUser.Looking_Gender
    query.equalTo("Gender", user.get("Gender"));
    // users with Looking_Gender = currentUser.Gender
    query.equalTo("Looking_Gender", user.get("Looking_Gender"));
    query.limit(1);

    ... etc

    // execute the query
    // i am using each just to show an convenient way to iterate the results
    // instead of setting limit(1) consider executing the query using first() instead 
    // android SDK has a getFirstInBackground() as well

    query.each(function(user) {
        // sendPushNotification is added in next code section
        return sendPushNotification(user);
    }).then(function() {
        response.success("success!");
    }, function(err) {
        response.error(err);
    });

});