public void sendBundleData(Fragment fragment) {


Bundle args= new Bundle();
args.putParcelableArrayList("verseValues",_bibleValues); /** Make the Object class Parcelable 1st */
fragment.setArguments(args);

}