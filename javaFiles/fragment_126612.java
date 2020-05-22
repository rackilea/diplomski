for (String category : categoriesList) {
        dbUtils.select(sql, category).stream()
            .limit(50)
            .forEach(entry -> {
                int websiteId = (int) entry[0];
                String url = (String) entry[1];
                String categoryName = (String) entry[2];
                downloadURL(websiteId, url, categoryName, executorService);
            });
    }