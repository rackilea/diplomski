//in your first/main thread
Set<String> dayWorkTypeIds = dayWorkTypes.map(d -> d.getId());

...

//in your new thread just query realm
Realm realm = Realm.getDefaultInstance();
RealmResults<DayWorkType> dayWorkTypes2 = realm
        .where(DayWorkType.class)
        .in("id", dayWorkTypeIds.toArray(new String[0]);

//now you can use dayWorkTypes2 as you want in your thread