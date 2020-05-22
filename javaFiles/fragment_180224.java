@RequestMapping(value = "/pages/save",method=RequestMethod.GET)
    public @ResponseBody String save(@RequestParam String widgetsList){
        GsonBuilder gson = new GsonBuilder();
        // register the custom deserializer for my WidgetAdapterClass
        gson.registerTypeAdapter(WidgetAdapter.class, new WidgetDeserialization());
        Type listType = new TypeToken<List<WidgetAdapter>>() {}.getType();
        // create gson an deserialize object
        List<WidgetAdapter> adapters = gson.create().fromJson( widgetsList, listType);
        // just for testing proposes
        for(WidgetAdapter a :adapters){
            System.out.println(a.getWidth());
        }

        return new Gson().toJson(new ActionResult("Ok"));
    }