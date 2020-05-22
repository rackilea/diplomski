private int mRadioPosition;

  public SchoolAdapter(Context context, int resId, RealmResults<School> realmResults,  Integer radioPosition, boolean automaticUpdate) {

        super(context, realmResults,  automaticUpdate);
        mRadioPosition = radioPosition;
    }