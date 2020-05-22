String lstr = "[12.88, 77.56],[12.81, 77.7156]";

List<Coordinate> cors = new ArrayList<Coordinate>();

String []coordinates = lstr.split("\\],\\[");

for(String cordinate:coordinates)
{
    String []xy = cordinate.split(",");
    cors.add(new Coordinate(xy[0],xy[1]));
}
System.out.println(cors);