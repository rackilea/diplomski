app.get('/leads/reassign',keycloak.enforcer(['leads:reassign'],{
    claims: function(request){
    return {
        "location":["chennai"]
    }
    }
    } ), function (req, res) {
        res.send("granted");
    });