Image img;
PImage terrain;

void update1() {

    if (img == null) {

        img = list.getRandom();
        terrain = image.getImg(); // get PImage from Image
        color c = terrain.get(int(p.x), int(p.y)); 

        // [...]
    }
}