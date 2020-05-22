public Operations(int rows, int cols, int objects, int times)
{
    this.rows = rows;
    this.cols = cols;
    this.objects = objects;
    this.times = times;
    world = new int[rows][cols];
}