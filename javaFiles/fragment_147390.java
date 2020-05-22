class ClassWhatever {
    public static void main(String[] args) {
        String url = "https://www.googleapis.com/books/v1/volumes?q=isbn:0735619670";
        // Assuming that you do in fact have the JSON string...
        String json = "the correct json";

        Container fullJsonObject = new Gson().fromJson(json, Container.class);

        for (Item i : fullJsonObject.items) {
            System.out.println(i.volumeInfo.authors[0]);
        }
    }

    private class Container {
        String kind;
        int totalItems;
        Item[] items;
    }

    private class Item {
        String kind;
        String id;
        String etag;
        ///blah
        VolumeInfo volumeInfo;
        String publisher;
        ///etc.

    }

    private class VolumeInfo {
        String title;
        String[] authors;
    }
}