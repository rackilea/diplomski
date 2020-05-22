public class RetroHelper {

      private static Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(Safety_aws_api.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

      public static Safety_aws_api api = retrofit.create(Safety_aws_api.class);
}