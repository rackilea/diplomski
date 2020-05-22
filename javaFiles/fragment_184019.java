// Use fastTag if exists
List<Class> fastClasses = new ArrayList<Class>();
try {
    // Will contain your TagHelp class
    fastClasses = Play.classloader.getAssignableClasses(FastTags.class);
} catch (Exception xe) {
    //
}
// Add FastTags class in first spot (takes precedence over your fasttags, 
// so tags with the same name as in the FastTags class won't work)
fastClasses.add(0, FastTags.class);
// Will contain the tag method
Method m = null;
String tName = tag.name;
String tSpace = "";
// Check for namespace
if (tName.indexOf(".") > 0) {
    tSpace = tName.substring(0, tName.lastIndexOf("."));
    tName = tName.substring(tName.lastIndexOf(".") + 1);
}
for (Class<?> c : fastClasses) {
    // Check Namespace Annotation first
    if (!c.isAnnotationPresent(FastTags.Namespace.class) && tSpace.length() > 0) {
        continue;
    }
    if (c.isAnnotationPresent(FastTags.Namespace.class) && !c.getAnnotation(FastTags.Namespace.class).value().equals(tSpace)) {
        continue;
    }
    // Try to find the FastTag
    try {          
        m = c.getDeclaredMethod("_" + tName, Map.class, Closure.class, PrintWriter.class, GroovyTemplate.ExecutableTemplate.class, int.class);
    } catch (NoSuchMethodException ex) {
        continue;
    }
}
if (m != null) {
    // If it did find a FastTag (m != null)
    print("play.templates.TagContext.enterTag('" + tag.name + "');");
    print("_('" + m.getDeclaringClass().getName() + "')._" + tName + "(attrs" + tagIndex + ",body" + tagIndex + ", out, this, " + tag.startLine + ");");
    print("play.templates.TagContext.exitTag();");
} else {
    // If it didn't find any FastTags (m == null)
    // Now it will try to look up an html / tag file
    print("invokeTag(" + tag.startLine + ",'" + tagName + "',attrs" + tagIndex + ",body" + tagIndex + ");");
}