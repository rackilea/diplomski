if (result != null && !result.isEmpty())
{
        tvResult.setVisibility(View.VISIBLE);
        tvError.setVisibility(View.INVISIBLE);
        Log.d("Error", "not null");
 }
 else{
        tvResult.setVisibility(View.INVISIBLE);
        tvError.setVisibility(View.VISIBLE);
        Log.d("Error", "null");
 }