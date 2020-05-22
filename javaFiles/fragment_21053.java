long difftime = System.nanoTime() - lastTime;
static long fpstn = 1000000000 / 30;
static int maxtimes = 10;// This is used to prevent what is commonly known as the spiral of death: the calcutaions are longer that the time you give them. in this case you have to increase the value of a base timechunk in your calculations
for (int i = 0; i < maxtimes; i++) {
    if (difftime >= fpstn) {
        world.updateVerlet(1);
    } else {
        world.updateVerlet((float)diffTime / (float)fpstn);
    }
    difftime -= fpstn;
    if (difftime <= 0)
        break;
}