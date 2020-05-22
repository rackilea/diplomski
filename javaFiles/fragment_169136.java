public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
        throws IOException, PortletException {
    String communityName = "";
    long communityId = 0;
    String cityName = "";
    long cityId = 0;
    String countySelected = ParamUtil.getString(resourceRequest, "countySelected");
    long countySelectedId = ParamUtil.getLong(resourceRequest, "countyDictionaryId");
    String communitySelected = ParamUtil.getString(resourceRequest, "communitySelected");
    long communitySelectedId = ParamUtil.getLong(resourceRequest, "communityDictionaryId");
    JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
    if (countySelected.equalsIgnoreCase("countySelected")) {
        try {
            int communitiesCount = CommunityDictionaryLocalServiceUtil.getCommunityDictionariesCount();
            List<CommunityDictionary> communities = CommunityDictionaryLocalServiceUtil.getCommunityDictionaries(0,
                    communitiesCount);
            if (countySelectedId == 0) {
                for (CommunityDictionary community : communities) {
                    communityName = community.getCommunityName();
                    communityId = community.getCommunityDictionaryId();
                    JSONObject communityObject = JSONFactoryUtil.createJSONObject();
                    communityObject.put("communityName", communityName);
                    communityObject.put("communityDictionaryId", communityId);
                    jsonArray.put(communityObject);
                }
            } else {
                for (CommunityDictionary community : communities) {
                    if (community.getCountyDictionaryId() == countySelectedId) {
                        communityName = community.getCommunityName();
                        communityId = community.getCommunityDictionaryId();
                        JSONObject communityObject = JSONFactoryUtil.createJSONObject();
                        communityObject.put("communityName", communityName);
                        communityObject.put("communityDictionaryId", communityId);
                        jsonArray.put(communityObject);
                    }
                }
            }
        } catch (SystemException e) {
            e.printStackTrace();
        }
    }
    if (communitySelected.equalsIgnoreCase("communitySelected")) {
        try {
            int citiesCount = CityDictionaryLocalServiceUtil.getCityDictionariesCount();
            List<CityDictionary> cities = CityDictionaryLocalServiceUtil.getCityDictionaries(0, citiesCount);
            if (communitySelectedId == 0) {
                for (CityDictionary city : cities) {
                    cityName = city.getCityName();
                    cityId = city.getCityDictionaryId();
                    JSONObject cityObject = JSONFactoryUtil.createJSONObject();
                    cityObject.put("cityName", cityName);
                    cityObject.put("cityDictionaryId", cityId);
                    jsonArray.put(cityObject);
                }
            } else {
                for (CityDictionary city : cities) {
                    if (city.getCommunityDictionaryId() == communitySelectedId) {
                        cityName = city.getCityName();
                        cityId = city.getCityDictionaryId();
                        JSONObject cityObject = JSONFactoryUtil.createJSONObject();
                        cityObject.put("cityName", cityName);
                        cityObject.put("cityDictionaryId", cityId);
                        jsonArray.put(cityObject);
                    }
                }
            }
        } catch (SystemException e) {
            e.printStackTrace();
        }
    }
    PrintWriter writer = new PrintWriter(resourceResponse.getPortletOutputStream());
    writer.write(jsonArray.toString());
    writer.flush();
    super.serveResource(resourceRequest, resourceResponse);
}