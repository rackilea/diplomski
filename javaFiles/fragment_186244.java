HttpResponse<String> response = Unirest
                .post("http://myserver.com/file")
                  .header("cache-control", "no-cache")
                  .header("Postman-Token", "02ec2fa1-afdf-4a2a-a535-353424d99400")
                .header("Content-Type", "application/json")
                .body("{some JSON body}")
                .asString();
System.out.println(response.getBody());