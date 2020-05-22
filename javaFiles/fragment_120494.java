ArrayList<ContentProviderOperation> ops
for (LatLng latLng : list) {
    ops.add(ContentProviderOperation.insert(Uri).withValue("userId", userId).withValue("lat", 32.3232)...build()
} 

getActivity().getContentResolver().applyBatch("AUTHORITY", ops)