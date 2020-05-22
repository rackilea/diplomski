"/api/login/" : {
      "post" : {
        "summary" : "Log in",
        "description" : "Here you can log in",
        "operationId" : "loginUsingPOST",
        "parameters" : [ {
          "name" : "username",
          "in" : "query",
          "description" : "The username",
          "required" : false,
          "type" : "string"
        }, {
          "name" : "password",
          "in" : "query",
          "description" : "The password",
          "required" : false,
          "type" : "string"
        } ]
      }
    }