Campsite campsite = new Campsite();
if (cursor.moveToFirst() {
    campsite.setName(cursor.getString(1));
    campsite.setLatitude(cursor.getDouble(6));
    campsite.setLongitude(cursor.getDouble(7));
}
cursor.close();
return campsite;