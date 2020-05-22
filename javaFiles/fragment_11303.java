public static void main(final String[] args) throws IOException {
        HashMap<Integer, User> users = new HashMap<Integer, User>();
        BufferedReader br = new BufferedReader(new FileReader("userinfo.data"));
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] userratings = line.split(",");
            int userColumn = Integer.parseInt(userratings[0]);
            int itemColumn = Integer.parseInt(userratings[1]);
            double ratingColumn = Double.parseDouble(userratings[2]);
            User user = users.get(userColumn);
            if (user == null) {
                user = new User(userColumn);
                users.put(userColumn, user);
            }
            user.add(new Item(itemColumn, ratingColumn));
        }
        br.close();

        for (User user : users.values()) {
            for (Item item : user.getItems()) {
                System.out.println(user.getId() + "\t" + item.getId() + "\t" + item.getRating());
            }
        }
    }