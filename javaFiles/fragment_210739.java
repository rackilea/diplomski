public class MealEntry extends RealmObject {

    @PrimaryKey @Required private String id;

    @Required private String title;

    /** The entry objects this meal-entry is added to */
    Entry entry;

    /** This time value describes when the user consumed this meal **/
    private int time;
// other fields

/**
* Creates a new MealEntry object in the realm.
 * <p>
 *     Note: It is important to use this factory method for creating {@link MealEntry} objects in realm.
 *     Under the hood, a {@link Entry} object is created for every MealEntry and linked to it.
 * </p>
 *
 * @param realm not null
 *
 * @return new MealEntry object which has been added to the <code>realm</code>
 */
public static MealEntry createInRealm(@NonNull Realm realm) {
    if(realm == null) {
        throw new IllegalArgumentException("'realm' may not be null");
    }

    MealEntry mealEntry = realm.createObject(MealEntry.class, UUID.randomUUID().toString());
    mealEntry.entry = Entry.createEntryAsMeal(realm, mealEntry);
    return mealEntry;
}