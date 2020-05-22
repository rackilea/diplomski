public class AnnotationBuilder {
    private StringBuilder temp = new StringBuilder();
    private List<SmaliAnnotation> annotations = new ArrayList<>();
    private boolean shouldAdd;

    private AnnotationBuilder() {
        // no-op
    }

    public static List<SmaliAnnotation> getAnnotations(List<String> lines, boolean hasPadding) {
        return new AnnotationBuilder().build(lines, hasPadding);
    }

    private List<SmaliAnnotation> build(List<String> lines, boolean hasPadding) {
        lines.stream().map(line -> hasPadding ? line.trim() : line).filter(line -> !line.isEmpty()).forEach(line -> doStuff(line));
        return annotations;
    }

    private void doStuff(final String cleanLine) {
        if (cleanLine.startsWith(".annotation")) {
            shouldAdd = true;
        }
        if (shouldAdd) {
            temp.append(cleanLine).append("\n");
        }
        if (cleanLine.equalsIgnoreCase(".end annotation")) {
            shouldAdd = false;
            annotations.add(new SmaliAnnotation(temp.toString()));
            temp.setLength(0);
        }
    }
}