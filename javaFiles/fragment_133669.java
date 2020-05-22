Gson gson= new Gson();
        List<Object> finalValue= new LinkedList<>();
        List<Object> value= new LinkedList<>();
        List<Object> value2= new LinkedList<>();
        List<String> names= new LinkedList<>();

        value.add("2017-10-02T21:06:08.134061801Z");
        value.add("sensor_2000:");
        value.add(10);
        value.add(1.0);

        value2.add("2017-10-02T21:06:08.134061801Z");
        value2.add("sensor_1000:");
        value2.add(20);
        value2.add(2.0);

        finalValue.add(value);
        finalValue.add(value2);

        names.add("time");
        names.add("sensor");
        names.add("sequence_number");
        names.add("component_id");

        System.out.println("values: " + gson.toJson(finalValue));
        System.out.println("names: " + names);


        LinkedList<JsonObject> finalList= new LinkedList<>();

        for(Object obj: finalValue)
        {
            JsonObject jsonObj= new JsonObject();
            List<Object> valueObj = (List<Object>) obj;
            int i=0;
            for(Object innerObj: valueObj)
            {
                if(names.get(i).equalsIgnoreCase("component_id"))
                {
                    jsonObj.addProperty(names.get(i), Double.parseDouble(String.valueOf(innerObj))) ;
                }
                else if(names.get(i).equalsIgnoreCase("sequence_number"))
                {
                jsonObj.addProperty(names.get(i), Integer.parseInt(String.valueOf(innerObj))) ;
                }
                else {
                    jsonObj.addProperty(names.get(i), String.valueOf(innerObj)) ;
                }
                i++;
            }

            finalList.add(jsonObj);
        }

        System.out.println(gson.toJson(finalList));

    }