public class SomeClass {

    private View tv;  // Post-erasure, TView -> View

    public SomeClass(View v){  // Post-erasure, TView -> View
        tv=(View) v; //unchecked cast warning due to cast of View to View
    }

}