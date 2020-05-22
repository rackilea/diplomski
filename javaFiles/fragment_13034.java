public class MovieReviewParser {
    public void parse(BufferedReader reader, MovieReviewHandler handler) {
        Pattern regex = Pattern.compile("product/productId:(.*)review/userId:(.*)review/profileName:(.*)"); // add other fields

        String line;
        while ((line = reader.readLine()) != null) {
            Matcher matcher = regex.matcher(line);
            if (!matcher.matches()) throw new RuntimeException();
            MovieReview review = new MovieReview();
            review.productId = matcher.group(1);
            review.userId = matcher.group(2);
            review.profileName = matcher.group(3);
            // etc

            handler.handle(review);
        }
    }
}