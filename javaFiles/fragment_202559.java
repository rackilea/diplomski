public class Source {

    private String myString;

    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }

}

public class Target {

    private List<String> myStrings;

    public List<String> getMyStrings() {
        return myStrings;
    }

    public void setMyStrings(List<String> myStrings) {
        this.myStrings = myStrings;
    }   

}

@Qualifier
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface FirstElement {
}

public class NonIterableToIterableUtils {

     @FirstElement
        public List<String> first(String in ) {
            if (StringUtils.isNotEmpty(in)) {
                return Arrays.asList(in);

            } else {
                return null;
            }
        }

}

@Mapper( uses = NonIterableToIterableUtils.class )
public interface SourceTargetMapper {

    SourceTargetMapper MAPPER = Mappers.getMapper( SourceTargetMapper.class );

    @Mappings( {
        @Mapping( source = "myString", target = "myStrings", qualifiedBy = FirstElement.class )
    } )
    Target toTarget( Source s );
}

public class Main {

    public static void main(String[] args) {
        Source s = new Source();
        s.setMyString("Item");

        Target t = SourceTargetMapper.MAPPER.toTarget( s );
        System.out.println( t.getMyStrings().get(0));

    }

}