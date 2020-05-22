JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
jsonObject.put("userId", themeDisplay.getUserId());
jsonObject.put("groupId", themeDisplay.getScopedGroupId());
...

MessageBusUtil.sendMessage("tour/roadie/setup", jsonObject.toString());