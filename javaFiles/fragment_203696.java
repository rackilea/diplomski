@FunctionalInterface
public interface ToStringInterface
    extends Formattable
{
    String asString();

    @Override
    default void formatTo(Formatter formatter, int flags, int width, int precision)
    {
        formatter.format("%s", this);
        // Or maybe even better:
        formatter.out().append(this.asString());
    }
}