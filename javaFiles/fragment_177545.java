private static ThreadLocal<Boolean> inInstrumentMethod = new ThreadLocal<>();

public static void onEntry(int methodID)
{
    if (inInstrumentMethod.get()!=null) {
        return;
    } else {
        inInstrumentMethod.set(true);
    }

    System.out.println("Method ID: " + methodID);

    inInstrumentMethod.set(null);
}