public class SafeStringBuilder  {
    private StringBuilder builder = new StringBuilder();

    public SafeStringBuilder append(String s) {
        if (s != null) 
            builder.append(s);
        return this;
    }
 }