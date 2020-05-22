InputStreamReader isr = new InputStreamReader(System.in);
BufferedReader br = new BufferedReader(isr);

StringBuilder sb = new StringBuilder();
char [] buf = new char[0xff];

while(br.read(buf, 0, 0xff))
{
    sb.append(new String(buf, "utf-8"));
}

String result = sb.toString();