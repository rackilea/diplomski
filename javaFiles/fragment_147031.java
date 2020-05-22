JSONObject rv = new JSONObject();
rv.add("firstValue", infoFirstValue());
rv.add("secondValue", infoSecondValue());
rv.add("thirdValue", infoThirdValue());

String gobject = gson.toJson(rv);
response.getWriter().write(gobject);