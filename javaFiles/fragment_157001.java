public class StringSplitter {

public String givenString;
public String[] separators;

public StringSplitter (String givenString, String... separators) {
    this.givenString=givenString;
    this.separators = separators;

    if(this.givenString == null || this.separators == null || this.separators.length < 1 ) {
        throw new IllegalArgumentException("invalid arguments passed");
    }
}

public List<String> splitMethod() {

    String newGivenString = givenString;

    // replace all other separators with the first one
    if(separators.length > 1) {
        // skip the first separator
        for(int idx = 1; idx < separators.length; idx++) {
            newGivenString = newGivenString.replaceAll(separators[idx], separators[0]);
        }
    }

    List<String> splitList  = Arrays.asList(newGivenString.split(separators[0]));

   System.out.println(splitList);

    return splitList;

}   

public static void main (String[] args) {

    StringSplitter var = new StringSplitter("one.two#three",Separator.DOT.toString(),Separator.HASH.toString());
    var.splitMethod();

    var = new StringSplitter("one.two#three,four",Separator.DOT.toString(),Separator.HASH.toString(),Separator.COMMA.toString());
    var.splitMethod();

    var = new StringSplitter("one.two#three four",Separator.DOT.toString());
    var.splitMethod();
}



enum Separator{

    DOT {
        @Override
        public String toString() {
            return "\\.";
        }
    },

    HASH {
        @Override
        public String toString() {
            return "#";
        }
    },

    COMMA {
        @Override
        public String toString() {
            return ",";
        }
    }

}