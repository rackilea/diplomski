http()
     .client(HttpTqaClient)
     .send()
     .get("/account/api/lk/lk-client/current")
     .accept("application/json")
     .contentType("application/json")
     .header("Authorization", "${global_auth_token}");