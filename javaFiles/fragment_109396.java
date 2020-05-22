public <T> List<T> readData(InputStream inputStream, Class<T> clazz) throws Exception {        
            ArrayList<Object> arrayList = new ArrayList<>();            
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, "UTF_8"));
            jsonReader.setLenient(true);
            JsonToken jsonToken = jsonReader.peek();
            switch (jsonToken) {
                case BEGIN_ARRAY:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList.add(gson.fromJson(jsonReader, clazz));
                    }
                    jsonReader.endArray();
                    break;
                case BEGIN_OBJECT:
                    T data = clazz.cast(gson.fromJson(jsonReader, clazz));
                    arrayList.add(data);
                    break;
                case NUMBER:
                    Integer number = Integer.parseInt(jsonReader.nextString());
                    arrayList.add(number);
                    break;
                default:
                    jsonReader.close();
                    inputStream.close();
                    return Collections.emptyList();
            }
            jsonReader.close();
            inputStream.close();
            return (List<T>) arrayList;        
    }