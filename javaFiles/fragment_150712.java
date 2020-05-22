package my.example.package;
public class Giant {
    public enum GiantWord { FEE, FIE, FO, FUM };
    public void sayGiantWord(GiantWord word) { /* ... */ }
    public void sayGiantWordJS(String word) {
        sayGiantWord(GiantWord.valueOf(word));
    }

    public static native JavaScriptObject toJS(final Giant g) /*-{
        var Giant = function() {
            this.sayGiantWord = function(word) {
                g.@my.example.package::sayGiantWordJS(Ljava/lang/String;)(word);
            };
        };
        return new Giant();
    }-*/;
}