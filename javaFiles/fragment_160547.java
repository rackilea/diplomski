@Override
public void onResponse(Call<ResObj> call, Response<ResObj> response) {

       ResObj resObj = response.body();

       if(resObj != null){ // checking object is not null

          if(resObj.getStatus()){

              Intent intent = new Intent(Login.this, ListActivity.class);
              intent.putExtra("mobile", mobile);
              startActivity(intent);

          } else{
              Toast.makeText(Login.this, "Phone Number is incorrect!", Toast.LENGTH_SHORT).show();
          }
       }else{
          // handle null response here.
       }
}