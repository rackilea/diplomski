if (otpa !=null)
{
    aotp = Double.parseDouble(request.getParameter("otpa"));
    p = aotp * x;
    out.println(p);
    Double totb = a - p;
}
else  
{
    out.println("nothing");
}