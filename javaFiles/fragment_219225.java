byte[] buffer = new byte[8192]; // or whatever you like, but declare it outside the loop
int count;
while ((count = in.read(buffer)) > 0)
{
  out.write(buffer, 0, count);
}
out.flush();
// then in a finally block ...
out.close();
in.close();