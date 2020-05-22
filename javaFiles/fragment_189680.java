public class NewsFeed implements Comparable<NewsFeed>{
        //your fields and getters/setters
        private DateFormat f = new SimpleDateFormat("dd/MM/yyyy");//or your pattern
        @Override
        public int compareTo(NewsFeed o) {
            try {
                return f.parse(this.getDate()).compareTo(f.parse(o.getDate()));
            } catch (ParseException e) {
                throw new IllegalArgumentException(e);
            }
       }
}