static String param1 = "a";
    static String param2 = "b";

    public static void main(String[] args) {
        try {
            StringBuilder url = new StringBuilder();
            url.append("&key=");
            url.append(URLEncoder.encode(param1, "UTF-8"));
            url.append("&h=");
            url.append(URLEncoder.encode(param2, "UTF-8"));
            System.out.println(url);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }