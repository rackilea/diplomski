//You create your builder that registers your custom serializer with the class you want to serialize
GsonBuilder builder = new GsonBuilder();
builder.registerTypeAdapter(Standard.class, new StandardSerializer());

//Then you create your Gson object
Gson gson = builder.create();
//Then you pass your object to the gson like
Standard s = DAOFactory.getInstance().getStandardDAO().findById(id);
gson.toJson(s);