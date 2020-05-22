public class ScheduledAContent extends ScheduledContent {
    private TypeAContent content;

    public void setContent(TypeAContent content) {
        this.content = content;
    }

    @Override
    public void doSomethingWithContent() {
        System.out.println("someField: " + content.getSomeField());
        System.out.println("anotherField: " + content.getAnotherField());
    }
}