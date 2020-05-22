JSONObject jsonRoot = new JSONObject(JSON_STRING);
JSONObject channel = jsonRoot.getJSONObject("rss").getJSONObject("channel");

System.out.println(channel);
if (channel.optJSONArray("item") == null) {
    channel.put("item", new JSONArray().put(channel.getJSONObject("item")));
    System.out.println(channel);
}

Gson gson = new Gson();
RSSWrapper wrapper = gson.fromJson(jsonRoot.toString(), RSSWrapper.class);

System.out.println(wrapper.rss.channel.item.get(0).title); // Title Here