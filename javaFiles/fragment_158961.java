JSONArray series=new JSONArray();
            series.put("Quantitiy");
            series.put("Price");
        mav.addObject("series", series);
        JSONArray array=new JSONArray();
        List list=WebKinmelServiceManager.select("select i From Item i", Item.class);
        for (Object object : list) {
            Item item=(Item) object;
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("x", item.getName());
                JSONArray array2=new JSONArray();
                array2.put(item.getQuantity());
                array2.put(item.getPrice());
            jsonObject.put("y", array2);

            array.put(jsonObject);
        }
        mav.addObject("data", array);