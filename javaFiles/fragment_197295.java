public class Test11 {
    static String[] colorPallete = new String[] {"#1F1A17", "#62934D", "#F9B03F", "#7959BC", "#74B8DE", "#E65641", "#7CC8BB", "#D7CE5D", "#D6BE95", "#B694D1"};

    public static void main(String[] args) {
        Map<String, String> idToColorMap = new HashMap<String, String>();

        List<News> newsList = new ArrayList<News>();
        newsList.add(new News("1", "title1", "description1"));
        newsList.add(new News("2", "title2", "description2"));
        newsList.add(new News("1", "title3", "description3"));
        newsList.add(new News("5", "title4", "description4"));
        newsList.add(new News("2", "title5", "description5"));
        newsList.add(new News("1", "title6", "description6"));
        newsList.add(new News("1", "title7", "description7"));
        newsList.add(new News("3", "title8", "description8"));
        newsList.add(new News("4", "title9", "description9"));
        newsList.add(new News("5", "title10", "description10"));
        newsList.add(new News("1", "title11", "description11"));
        newsList.add(new News("6", "title12", "description12"));

        int colorIndex = 0;
        for (int i = 0; i < newsList.size(); i++) {
            if (newsList.size() > 1 && !idToColorMap.containsKey(newsList.get(i).getId())) {
                News currentNews = newsList.get(i);
                currentNews.setColor(colorPallete[colorIndex]);
                idToColorMap.put(currentNews.getId(), colorPallete[colorIndex]);

                for (int j = i + 1; j < newsList.size(); j++) {
                    if (newsList.get(j).getId().equals(currentNews.getId())) {
                        newsList.get(j).setColor(colorPallete[colorIndex]);
                    }
                }

                if (++colorIndex == colorPallete.length) {
                    colorIndex = 0;
                }
            } else {
                newsList.get(0).setColor(colorPallete[0]);
                idToColorMap.put(newsList.get(0).getId(), colorPallete[0]);
            }
        }

        for (News news: newsList) {
            System.out.println("News id=" + news.getId() + ", title=" + news.getTitle() + ", description=" + news.getDescription() + ", color=" + news.getColor());
        }

        for (Map.Entry<String, String> entry: idToColorMap.entrySet()) {
            System.out.println("Id to color: id=" + entry.getKey() + ", color=" + entry.getValue());
        }
    }
}

class News {
    String id;
    String title;
    String description;
    String color;

    News(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}