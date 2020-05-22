//RetrofitArrayAPI.innerURL = "/Login.php?M_cnic=4956";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    RetrofitArrayAPI service = retrofit.create(RetrofitArrayAPI.class);
  String M_cnic = cnic.getText().toString();
    //Call<List<Student>> call = service.getDetails();
    //Call<List<Student>> call = service.getDetails();
    //service.login( )

   // M_cnic="4956";

    Call<Student> call = service.getDetails(M_cnic);