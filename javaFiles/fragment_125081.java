import com.sun.javadoc.*;

public class ListTags {
    public static boolean start(RootDoc root){ 
        String tagName = "mytag";
        writeContents(root.classes(), tagName);
        return true;
    }

    private static void writeContents(ClassDoc[] classes, String tagName) {
        for (int i=0; i < classes.length; i++) {
            boolean classNamePrinted = false;
            MethodDoc[] methods = classes[i].methods();
            for (int j=0; j < methods.length; j++) {
                Tag[] tags = methods[j].tags(tagName);
                if (tags.length > 0) {
                    if (!classNamePrinted) {
                        System.out.println("\n" + classes[i].name() + "\n");
                        classNamePrinted = true;
                    }
                    System.out.println(methods[j].name());
                    for (int k=0; k < tags.length; k++) {
                        System.out.println("   " + tags[k].name() + ": " 
                        + tags[k].text());
                    }
                } 
            }
        }
    }
}