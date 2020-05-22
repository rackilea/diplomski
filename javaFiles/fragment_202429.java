if (Request.Headers["X-Requested-With"] != "XMLHttpRequest")
{
     Response.Write("AJAX Request only.");
     Response.End();
     return;
}