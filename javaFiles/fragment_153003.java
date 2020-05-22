String s;

while((System.currentTimeMillis()<end))
{
    if (bufferedReader.available() > 0)
        s += bufferedReader.readLine();
}

bufferedReader.close();