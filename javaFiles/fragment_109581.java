public interface InformationProvider {
    public void getInfo(int position);
}

public class InformationProviderImpl implements InformationProvider {
    public void getInfo(int position) {
         // your implementation
    }
}



public class InformationProviderValidator implements InformationProvider {
    private final InformationProvider provider;
    private final int min;
    private final int max;
    public InformationProviderValidator(InformationProvider provider, int min, int max) {
        this.provider = provider;
        this.min = min;
        this.max = max;
    }
    public void getInfo(int position) {
        if(postion < min  || position > max) {
            throw new IllegalArgumentException("Wrong position")l
        }
        return provider.getInfo(position);
    }
}