public class rectangle 
{
    float width=1;
    float height=1;
    float perimeter;

    public boolean isValidWidth(float w) {
       return (w < 20 && w > 0);
    }

    public void setWidth(float w)
    {
       if(isValidWidth(w)) {
           width = w;
       } else {
           throw new IllegalArgumentException("Invalid width");
       }
    }

    // and similarly for height

}