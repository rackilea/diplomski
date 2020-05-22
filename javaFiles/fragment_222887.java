public class Section
{
    public User teacher; // who teaches it
    public Course course; // what is the subject, because > 1 teacher might teach the same one.
    public TimeBlock timeBlock; // when is this section administered?
    public Venue venue; // what room or what facility
}