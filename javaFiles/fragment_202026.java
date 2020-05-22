@Override
public void onResponse(Call<ResponseApi> call, Response<ResponseApi> response) {
    Log.d(TAG, "services: " + response.getEmbeddedServices());
    // Here you can loop the response.getEmbeddedServices() which is a List of ServiceData and get each of the ids. Ex:
    for (ServiceData serviceData : response.getEmbeddedServices()) {
        Log.d(TAG, "service Id: " + serviceData.getId());
        // Here you have access to the ids and can do whatever you need with them.
    }
}