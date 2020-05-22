BoxResourceHub hub = new BoxResourceHub();
BoxJSONParser parser = new BoxJSONParser(hub);
this.client = new BoxClient(key,
                            clientSecret,
                            hub,
                            parser,
                            new RESTClient(),
                            new BoxConfigBuilder().build());