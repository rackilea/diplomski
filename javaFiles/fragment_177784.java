counter = (Counter) request.getSession().getAttribute("counter");
if (counter == null)
{
    counter = new Counter();
    request.getSession().setAttribute("counter", counter);
}