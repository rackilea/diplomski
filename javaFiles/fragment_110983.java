JSONArray tasks = new JSONArray(result);
        for (int i = 0; i < tasks.length(); i++) {
            JSONObject object = tasks.getJSONObject(i);
            StructureImage image = new StructureImage();
            image.title = object.getString("title");
            image.tozihat = object.getString("tozihat");
            image.thumbnail = object.getString("thumbnail");
            image.url = object.getString("url");

            DownloadManager.addToDownloadList(image.thumbnail);
            images.add(image);

        }