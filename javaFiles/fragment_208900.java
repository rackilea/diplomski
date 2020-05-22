private MAtt SetField(Context mContext, String name){
    MAtt aField = new MAtt(); //Create object
    int id = mContext.getResources().getIdentifier(name, "string", mContext.getPackageName());
    aField.name=mContext.getString(id);
    return aField;
}