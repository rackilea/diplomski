List<Circle> listOfCircles = new ArrayList<Circle>();
boolean flag = true;
int color;
for (Circle currentCircle: listOfCircles) {
    if (currentCircle.status == true) {
        if (color == null) {
            color = currentCircle.color;
        } else {
            if (color != currentCircle.color) {
                flag = false;
            };
        };
    };
};
// flag now holds true or false according to your needs.