protected void Page_Load(object sender, EventArgs e) 
{
    if (Page.IsPostback)
    {
        // a and b are names of input fields in our page.
        string a = Request["a"];
        string b = Request["b"];

       // Let's assume we've initialized the web service client as a property.
       Client.Create(new ServiceThing(a, b));
    }
}