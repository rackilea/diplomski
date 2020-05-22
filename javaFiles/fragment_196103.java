public class CArea<T extends Enum<T>>
{
    private final AtomicReference<T> type;

    public CArea(T enumVal)
    {
        type = new AtomicReference<>(enumVal);
    }
} 

CArea area1 = new CArea<>(EArea.SIDEWALK);
CArea area2 = new CArea<>(EArea.DIRECTLANE);