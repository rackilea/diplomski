ClientResponse response = webResource.path("/iotdevices1").queryParam("api-version", "2016-02-03")
                    .header("Content-Type", "application/json")
                    .header("If-Match", "*")
                    .header("Authorization",
                            "SharedAccessSignature sr=xxxx.azure-devices.net&sig=xxxxxx&se=1497490976&skn=iothubowner")
                    .delete(ClientResponse.class);