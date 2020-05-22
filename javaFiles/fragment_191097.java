StringBuilder builder = new StringBuilder(); 
String line;
do
{
    line = in.readLine(); 
    if (line == "") break;
    builder.append(line);
}
while (true);
// use builder as needed...
// read message body data if headers say there
// is a body to read, per RFC 2616 Section 4.4...