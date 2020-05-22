public class Entry extends RealmObject {
    private static final int ENTRY_MEAL = 0;
    private static final int ENTRY_DRINK = 1;
    private static final int ENTRY_SYMPTOM = 2;
    private static final int ENTRY_MEDICINE = 3;

    /** The tag describes what kind of entry it represents */
    private int tag;

    /* Only one of these can be set, according to what this entry represents. */
    @Nullable private MealEntry mealEntry;
    @Nullable private DrinkEntry drinkEntry;
    @Nullable private SymptomEntry symptomEntry;
    @Nullable private MedicineEntry medicineEntry;

    /** The time value this entry was created at */
    /** Format: hours + minutes * 60 */
    private int time;

    public int getTime() {
        return time;
    }

/* Can only be accessed from within the 'data' package */

    void setTime(int time) {
        this.time = time;
    }

/**
     * Creates a new entry object in the realm database and tags it as 'MEAL'
     *
     * @param realm not null
     * @param mealEntry the {@link MealEntry} object to map this entry to, not null
     *
     * @return the newly created entry
     */
    static Entry createEntryAsMeal(@NonNull final Realm realm, @NonNull final MealEntry mealEntry) {
        if(realm == null) {
            throw new IllegalArgumentException("'realm' may not be null");
        }
        if(mealEntry == null) {
            throw new IllegalArgumentException("'mealEntry' may not be null");
        }

        Entry entry = realm.createObject(Entry.class);
        entry.tag = ENTRY_MEAL;
        entry.mealEntry = mealEntry;
        return entry;
        }

/* Same methods for other tag types ... */