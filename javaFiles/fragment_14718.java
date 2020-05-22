Bundle bundle = new Bundle();
    ArrayList<Parcelable> parcels = new ArrayList<>();
    Intent resultData = new Intent();
    Uri uri1 = Uri.parse("file://mnt/sdcard/img01.jpg");
    Parcelable parcelable1 = (Parcelable) uri1;
    parcels.add(parcelable1);
    bundle.putParcelableArrayList(Intent.EXTRA_STREAM, parcels);
    // Create the Intent that will include the bundle.
    resultData.putExtras(bundle);

    intending(not(isInternal())).respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData));