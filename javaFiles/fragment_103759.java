public Node turn_right(Node aNode, int which_wheel)
{
   Node newNode = (Node) aNode.clone();

    int[][] yellow = new int[3][3];
    int[][] blue = new int[3][3];
    int[][] green = new int[3][3];

    if(which_wheel==0) //turn yellow wheel of this node to right
    {
        yellow[1][0] = newNode.getYellow_wheel()[0][0];
        yellow[2][0] = newNode.getYellow_wheel()[1][0];
        yellow[2][1] = newNode.getYellow_wheel()[2][0];
        yellow[2][2] = newNode.getYellow_wheel()[2][1];
        yellow[1][2] = newNode.getYellow_wheel()[2][2];
        yellow[0][2] = newNode.getYellow_wheel()[1][2];
        yellow[0][1] = newNode.getYellow_wheel()[0][2];
        yellow[0][0] = newNode.getYellow_wheel()[0][1];

        blue[0][0] = newNode.getBlue_wheel()[0][0];
        blue[0][1] = newNode.getBlue_wheel()[0][1];
        blue[0][2] = newNode.getBlue_wheel()[0][2];
        blue[1][2] = newNode.getBlue_wheel()[1][2];
        blue[2][1] = newNode.getBlue_wheel()[2][1];
        blue[2][2] = newNode.getBlue_wheel()[2][2];
        blue[1][0] = newNode.getYellow_wheel()[1][2];
        blue[2][0] = newNode.getYellow_wheel()[2][2];

        green = newNode.getGreen_wheel();

    }
    else if(which_wheel == 1)// turn blue wheel of this node to right
    {

        blue[1][0] = newNode.getBlue_wheel()[0][0];
        blue[2][0] = newNode.getBlue_wheel()[1][0];
        blue[2][1] = newNode.getBlue_wheel()[2][0];
        blue[2][2] = newNode.getBlue_wheel()[2][1];
        blue[1][2] = newNode.getBlue_wheel()[2][2];
        blue[0][2] = newNode.getBlue_wheel()[1][2];
        blue[0][1] = newNode.getBlue_wheel()[0][2];
        blue[0][0] = newNode.getBlue_wheel()[0][1];


        yellow[0][0] = newNode.getYellow_wheel()[0][0];
        yellow[0][1] = newNode.getYellow_wheel()[0][1];
        yellow[1][0] = newNode.getYellow_wheel()[1][0];
        yellow[2][0] = newNode.getYellow_wheel()[2][0];
        yellow[2][1] = newNode.getYellow_wheel()[2][1];
        yellow[2][2] = newNode.getYellow_wheel()[2][2];
        yellow[0][2] = newNode.getBlue_wheel()[0][0];
        yellow[1][2] = newNode.getBlue_wheel()[1][0];

        green[0][0] = newNode.getGreen_wheel()[0][0];
        green[0][1] = newNode.getGreen_wheel()[0][1];
        green[0][2] = newNode.getGreen_wheel()[0][2];
        green[1][2] = newNode.getGreen_wheel()[1][2];
        green[2][1] = newNode.getGreen_wheel()[2][1];
        green[2][2] = newNode.getGreen_wheel()[2][2];
        green[1][0] = newNode.getBlue_wheel()[1][2];
        green[2][0] = newNode.getBlue_wheel()[2][2];
    }
    else if (which_wheel == 2)//turn green wheel of this node to right
    {
        green[0][0] = newNode.getGreen_wheel()[0][1];
        green[0][1] = newNode.getGreen_wheel()[0][2];
        green[0][2] = newNode.getGreen_wheel()[1][2];
        green[1][2] = newNode.getGreen_wheel()[2][2];
        green[2][2] = newNode.getGreen_wheel()[2][1];
        green[2][1] = newNode.getGreen_wheel()[2][0];
        green[2][0] = newNode.getGreen_wheel()[1][0];
        green[1][0] = newNode.getGreen_wheel()[0][0];

        yellow = newNode.getYellow_wheel();

         blue[0][0] = newNode.getBlue_wheel()[0][0];
        blue[0][1] = newNode.getBlue_wheel()[0][1];
        blue[1][0] = newNode.getBlue_wheel()[1][0];
        blue[2][0] = newNode.getBlue_wheel()[2][0];
        blue[2][1] = newNode.getBlue_wheel()[2][1];
        blue[2][2] = newNode.getBlue_wheel()[2][2];
        blue[0][2] = newNode.getGreen_wheel()[0][0];
        blue[1][2] = newNode.getGreen_wheel()[1][0];
    }
    newNode= new Node(yellow,blue,green);
    return newNode;
}