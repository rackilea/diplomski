if (jsonObject.isNull("AverageRating")) {
    Toast.makeText(this, "Cannot Convert!!", Toast.LENGTH_LONG).show();
    //float set to 0
} else {
    Float.valueOf(jsonObject.getString("AverageRating"));
}