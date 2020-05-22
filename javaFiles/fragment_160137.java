JSONObject metaDataObject = jsonObject.getJSONObject("metadata");

String md5EncodedValue = metaDataObject.getJSONObject("audio_properties")
        .getString("md5_encoded");

System.out.println(md5EncodedValue);