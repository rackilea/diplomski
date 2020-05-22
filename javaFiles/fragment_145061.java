String body = "{deviceId: \"iotdevices1\"}";
ClientResponse response = webResource.path("/iotdevices1").queryParam("api-version", "2016-02-03")
                    .header("Content-Type", "application/json")
                    .header("Authorization",
                            "SharedAccessSignature sr=xxxx.azure-devices.net&sig=xxxxxxxx&se=1497357420&skn=iothubowner")
                    .put(ClientResponse.class, body);