import java.lang.reflect.Field;

public class ThemeChanger {

ThemeChanger(Context context){
    Field[] myFields;
    String myFullNameStyle;
    String myNameStyle;

    // Get all styles using reflection
    myFields = R.style.class.getFields();
    // Drill in into single style resource
    for (int i=0; i<myFields.length; i++) {
        myFullNameStyle = myFields[i].toString();
        if (myFullNameStyle.length()>0) {
            int pos = myFullNameStyle.lastIndexOf('.');
            if (pos!=-1) {
                myNameStyle = myFullNameStyle.substring(pos + 1);
                myNameStyle = myNameStyle.replace('_', '.');
                int myStyleId = context.getResources().getIdentifier(myNameStyle, "style", context.getPackageName());
                if (myStyleId != 0) {
                    int myTypeId[] = {R.attr.my_type};
                    String myType = context.obtainStyledAttributes(myStyleId, myTypeId).getString(0);
                    if (myType == "my_theme") {
                        // Do all things with other custom attrs,
                        // like populating a array to use with a menù
                    }
                }
            }
        }
    }
}
}