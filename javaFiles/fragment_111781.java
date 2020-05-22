int count = 0;
while(file.hasNextLine())
{
    count++;
    if (count <= 1) {
      file.nextLine ();
      continue;
    }
    ....
}