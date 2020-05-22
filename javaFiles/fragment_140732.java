Elements images = document.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
for (Element image : images) 
{
    System.out.println("height : " + image.attr("height"));
    System.out.println("width : " + image.attr("width"));
}