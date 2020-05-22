List<Video> videos = new ArrayList<Video>();
while (rs.next())
{
    ... read data ...
    videos.add(new Video(...));
}