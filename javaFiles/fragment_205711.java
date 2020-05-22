import java.lang.annotation.Annotation;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConfigurationGenerator {

    public static void main(String[] args) throws Exception {

        List<String> cleanedList = Files
                .readAllLines(Paths.get("DeprecatedClassList.txt")).stream()
                .map(ConfigurationGenerator::removeGenerics)
                .filter(ConfigurationGenerator::hasDeprecatedConstructor)
                .collect(Collectors.toList());

        String propertyName = "org.eclipse.jdt.ui.typefilter.enabled=";
        String propertyValue = String.join(";", cleanedList).concat(";");

        String configuration = propertyName + propertyValue;
        System.out.println("Configuration property...");
        System.out.println(configuration);
    }

    public static String removeGenerics(String className) {
        int openingBracket = className.indexOf("<");
        if (openingBracket == -1)
            return className;
        else
            return className.substring(0, openingBracket);
    }

    public static boolean hasDeprecatedConstructor(String className) {

        Class theClass = null;
        try {
            theClass = Class.forName(className);
        } catch (Throwable e) {
            // Ignore bad results
            System.out.println("Skipping: " + className);
            return false;
        }

        Annotation[] annotations = theClass.getAnnotations();
        Optional<Annotation> deprecatedConstructor = Stream
                .of(annotations)
                .filter(annotation -> annotation.toString().equals(
                        "@java.lang.Deprecated()")).findAny();

        return deprecatedConstructor.isPresent();
    }
}