Gson gson = new GsonBuilder()
            .setExclusionStrategies(new ExclusionStrategy() {
                @Override
                public boolean shouldSkipField(FieldAttributes f) {
                    return f.getDeclaringClass().equals(RealmObject.class);
                }

                @Override
                public boolean shouldSkipClass(Class<?> clazz) {
                    return false;
                }
            })
            .registerTypeAdapter(new TypeToken<RealmList<RealmDoubleObject>>() {}.getType(), new TypeAdapter<RealmList<RealmDoubleObject>>() {

                @Override
                public void write(JsonWriter out, RealmList<RealmDoubleObject> value) throws IOException {
                    // Ignore
                }

                @Override
                public RealmList<RealmDoubleObject> read(JsonReader in) throws IOException {
                    RealmList<RealmDoubleObject> list = new RealmList<RealmDoubleObject>();
                    in.beginArray();
                    while (in.hasNext()) {
                        Double valor = in.nextDouble();
                        list.add(new RealmDoubleObject(valor));
                    }
                    in.endArray();
                    return list;
                }
            })
            .create();