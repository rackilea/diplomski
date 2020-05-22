reduce(key, Iterable values, context) {
  String index_id = null;
  count = 1;
  String previousReview_id = null;
  for(value: values) {
      Split split[] = values.split("\\|");
      ....

      //when consecutive review_ids are same, we increment count
      //and as soon as the review_id differ, we emit, reset the counter and print
      //the previous review_id detected.
      if (split[0].equals("-1") && split[1].equals(previousReview_id)) {
          count++;
      } else if(split[0].equals("-1") && !split[1].equals(prevValue)) {
          context.write(previousReview_id + "\t" + index_id + "\t" + count);
          previousReview_id = split[1];//resting with new review_id id
          count=1;//resetting count for new review_id
      } else {
         index_id = split[0]; 
      }
  }
  //the last  previousReview_id will be left out, 
  //so, writing it now after the loop  completion
  context.write(previousReview_id + "\t" + index_id + "\t" + count);

}