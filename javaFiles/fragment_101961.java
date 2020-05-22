JSONObject jsonObject = (JSONObject)Json.createObjectBuilder()
                        .add(
                            username,
                            Json.createObjectBuilder()
                                .add("username", username)
                                .add("password", password)
                                .add("service",
                                    Json.createArrayBuilder()
                                      .add(service)
                                )
                        ).build();