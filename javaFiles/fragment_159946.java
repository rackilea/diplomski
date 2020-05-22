realm.beginTransaction();

Unit unit = realm.where(Unit.class)
                 // write your condition for extracting of Unit object
                 .equalTo("id", unit_id).findFirst();

if(unit == null){
    Log.e(APP_TAG, "Unit " + unit_id + " not found");
    realm.cancelTransaction();
    return;
}

Subunit subunit = realm.createObject(Subunit.class);
// setup subunit fields

unit.getSubunits().add(subunit);

realm.commitTransaction();