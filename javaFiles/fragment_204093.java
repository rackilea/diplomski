public class ScheduledBContent extends ScheduledContent {
    private TypeBContent content;

    public void setContent(TypeBContent content) {
        this.content = content;
    }

    @Override
    public void doSomethingWithContent() {
        System.out.println("someField: " + content.getSomeField());
        System.out.println("anotherField: " + content.getAnotherField());
    }
}