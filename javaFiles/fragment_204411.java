// ...
Stream webStream = webResponse.GetResponseStream();
using (var stream = File.Create(@"C:\file.pdf"))
{
    webStream.CopyTo(stream);
}