public int[] void findCircleWithRadius(Circle[][] circles, double r) {

for(int i = 0; i < circles.length; i++) { //search the row
    for(int j = 0; j < circles[i].length; j++) { //search each column
        double temp = circles[i][j].getRadius();
        if(temp == r)
        return {i, j};
    }
 }
 return {-1, -1};
 }

public static void swapCircles(Circles[][] circles, double r1, double r2) {

int[] rad1 = this.findCircleWithRadius(circles, r1);
int[] rad2 = this.findCircleWithRadius(circles, r2);
Circle radius1 = circles[rad1[0]][rad1[1]];
Circle radius2 = circles[rad2[0]][rad2[1]];

Circle temp2 = radius2;

radius2 = radius1;
radius1 = temp2;
}