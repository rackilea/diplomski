retrofitBuilder.addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
            .registerTypeAdapter(User.class, new JsonSerializer<User>() {
                @Override
                public JsonElement serialize(User src, Type typeOfSrc, JsonSerializationContext context) {
                    if (src instanceof FbUser ) {
                        return context.serialize(src, FbUser.class);
                    }
                    return context.serialize(src);
                }
            }).create()));