while((data = bread.readLine()) != null)
{
    if (data.equals("ENDMSG")) {
        break;
    }
    System.out.println(data);
}