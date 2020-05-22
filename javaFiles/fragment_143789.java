Gson gson = new Gson();
Type listType = new TypeToken<HighVelocityPojo>() {
}.getType();

HighVelocityPojo highVelocityPojo = gson.fromJson(response.toString(), listType);
Log.e("size", highVelocityPojo.getSKU().size() + "");