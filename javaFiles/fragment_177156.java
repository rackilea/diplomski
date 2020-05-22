try {
     tokens = line.split(";");
     tempData = tokens[0].trim().split(" ");
     windData = tokens[1].trim().split(" ");   
} catch (Exception error)
{
     Log.d("Parsing error:", error+"");
}