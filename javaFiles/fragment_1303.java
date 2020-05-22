public class WWorkoutObjectList
{
    private ComparatorWWorkoutObject mComparator = new ComparatorWWorkoutObject();
    private List<WWorkoutObject> mObjects = new ArrayList<WWorkoutObject>();

    public WWorkoutObjectList(List<WExercise> wExercises, List<WCardio> wCardio, List<WPause> wPause)
    {
        init(wExercises, wCardio, wPause);
    }

    public synchronized void init(List<WExercise> wExercises, List<WCardio> wCardio, List<WPause> wPause)
    {
        mObjects.clear();
        if (wExercises != null) {
            for (WExercise we : wExercises) {
                mObjects.add(new WWorkoutObject(we));
            }
        }
        if (wCardio != null) {
            for (WCardio wc : wCardio) {
                mObjects.add(new WWorkoutObject(wc));
            }
        }
        if (wPause != null) {
            for (WPause wp : wPause) {
                mObjects.add(new WWorkoutObject(wp));
            }
        }
        sort();
    }

    public synchronized void add(WWorkoutObject wObject)
    {
        mObjects.add(wObject);
        sort();
    }

    public int size()
    {
        return mObjects.size();
    }

    public WWorkoutObject get(int index)
    {
        return mObjects.get(index);
    }

    public synchronized WWorkoutObject remove(int index)
    {
        return mObjects.remove(index);
    }

    // ----------------
    // Hilfsfunktionen
    // ----------------

    public synchronized WExercise getNextExercise(int currentIndex)
    {
        for (int i = currentIndex + 1; i < mObjects.size(); i++)
        {
            if (mObjects.get(i).isWCardio())
                return null;
            if (mObjects.get(i).isWExercise())
                return mObjects.get(i).getWExercise();
        }
        return null;
    }

    public synchronized int getFragmentCount()
    {
        int counter = 0;
        for (WWorkoutObject wo : mObjects)
        {
            if (wo.isFragmentObject())
                counter++;
        }
        return counter;
    }

    public synchronized WWorkoutObject getFragmentObject(int fragmentIndex)
    {
        if (fragmentIndex < 0 || fragmentIndex >= mObjects.size())
            return null;
        int counter = 0;
        for (WWorkoutObject wo : mObjects)
        {
            if (wo.isFragmentObject())
            {
                if (counter == fragmentIndex)
                    return mObjects.get(i);
                counter++;
            }
        }
        return null;
    }

    public synchronized List<WWorkoutObject> getFragmentsObjectsList()
    {
        List<WWorkoutObject> list = new ArrayList<WWorkoutObject>();
        for (WWorkoutObject wo : mObjects)
        {
            if (wo.isFragmentObject())
                list.add(wo);
        }
        return list;
    }

    public synchronized List<WWorkoutObject> list()
    {
        ArrayList<WWorkoutObject> result = new ArrayList<WWorkoutObject>();
        for (WWorkoutObject wo : mObjects)
            result.add(wo);
        return result;
    }

    // ----------------
    // private Funktionen
    // ----------------

    private void sort()
    {
        Collections.sort(mObjects, mComparator);
    }
}