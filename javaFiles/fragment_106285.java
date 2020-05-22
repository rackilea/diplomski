Double totb = 0.0;
if (otpa !=null)
{
    aotp = Double.parseDouble(request.getParameter("otpa"));
    p = aotp * x;
    out.println(p);
    totb = a - p;
}
else  
{
    out.println("nothing");
}