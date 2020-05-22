Collections.sort(newsList, new Comparator<NewsFeed>() {
        DateFormat f = new SimpleDateFormat("dd/MM/yyyy");//or your pattern
        @Override
        public int compare(NewsFeed o1, NewsFeed o2) {
            try {
                return f.parse(o1.getDate()).compareTo(f.parse(o2.getDate()));
            } catch (ParseException e) {
                throw new IllegalArgumentException(e);
            }
        }
    });