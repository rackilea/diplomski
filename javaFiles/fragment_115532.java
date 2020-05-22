public static string DivList(this HtmlHelper helper, IList<string> list, string divClass)
{
    var sb = new StringBuilder();
    foreach(string item in list)
    {
        sb.AppendFormat("<div class=\"{0}\">{1}</div>", divClass, item); 
    }     
    return sb.ToString();
}