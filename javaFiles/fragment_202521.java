{
    "source" : "password",
    "condition" : {
        "type" : "text/javascript",
        "source" : "object.password != null"
    },
    "transform" : {
        "type" : "text/javascript",
        "source" : "openidm.decrypt(source);"
    },
    "target" : "userPassword"
}