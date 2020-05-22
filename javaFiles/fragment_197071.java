@Override
boolean equals (Object other)
{
    if (!(other instanceof Sentence))
        return false;
    if (other == this)
        return true;
    Sentence o = (Sentence) other;
    return o.subject.equals(subject) && o.object.equals(object) && o.verb.equals(verb);
}

@Override
public int hashCode ()
{
    return Objects.hash(object, subject, verb); // this method only exists since Java 7
}