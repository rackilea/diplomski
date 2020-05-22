private void caller()
{
    StringBuilder s = new StringBuilder();
    s.append("test");
    calledMethod1(s);
    System.out.println(s.toString());
    calledMethod2(s);
    System.out.println(s.toString());
}

private void calledMethod1(StringBuilder buffer)
{
    buffer = new StringBuilder();
    buffer.append("calledMethod1");
    return;
}

private void calledMethod2(StringBuilder buffer)
{
    buffer.append(", calledMethod2");
    return;
}