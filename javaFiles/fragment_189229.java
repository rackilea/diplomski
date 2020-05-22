public class Task<T> {
    T submission;

    // You can now use T as a class (but not with `new` or some other things)
    public T getSubmission() { return submission; }
    public void setSubmission(T new) { submission = new; }
    public Task(T t) { setSubmission(t); }
    // etc.
}