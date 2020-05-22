public class Phleem{

    public Phleem(final String phloom){
        if(phloom == null){
            throw new NullPointerException();
        }
        this.phloom = phloom;
    }

    private final String phloom;

    public String getPhloom(){
        return phloom;
    }

    @Override
    public boolean equals(final Object obj){
        if(obj instanceof Phleem){
            // downcast here
            final Phleem other = (Phleem) obj;
            return other.phloom.equals(phloom);
        }
        return false;
    }

    // ...

}