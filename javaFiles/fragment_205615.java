List<LatestNewsDTO> latestNewsList =
    latestNewses.stream()
                .map(objects -> {
                    LatestNewsDTO latestNews = new LatestNewsDTO();
                    latestNews.setId(((BigInteger) objects[0]).intValue());
                    latestNews.setCreatedOn((Date) objects[1]);
                    latestNews.setHeadLine((String) objects[2]);
                    latestNews.setContent(((Object) objects[3]).toString());
                    latestNews.setType((String) objects[4]);
                    return latestNews;
                })
                .collect(Collectors.toList());