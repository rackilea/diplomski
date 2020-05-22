public boolean equals(Object obj)
{
    // test for identity
    if (this == obj) return true;

    // check that obj is not null, and that it is an instance of Base
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;

    // compare attributes
    Base other = (Base) obj;
    if (i != other.i) return false;
    if (str == null && other.str != null) return false;
    if (!str.equals(other.str)) return false;
    return true;
}