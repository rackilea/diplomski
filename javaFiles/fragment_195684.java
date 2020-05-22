/**
 * Check if two rectangles collide
 * x_1, y_1, width_1, and height_1 define the boundaries of the first rectangle
 * x_2, y_2, width_2, and height_2 define the boundaries of the second rectangle
 */
boolean rectangle_collision(float x_1, float y_1, float width_1, float height_1, float x_2, float y_2, float width_2, float height_2)
{
  return !(x_1 > x_2+width_2 || x_1+width_1 < x_2 || y_1 > y_2+height_2 || y_1+height_1 < y_2);
}