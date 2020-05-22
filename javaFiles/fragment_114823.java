public class StoryBook extends Book {
    public StoryBook() {
        System.out.println(this.variable); // this.variable is visible
    }

    public boolean equals(StoryBook other) {
        return this.variable == other.variable; // error: StoryBook.variable is not visible
    }
}