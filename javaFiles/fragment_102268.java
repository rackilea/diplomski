public String setStars(){

    StringBuilder sb = new StringBuilder();

    for (int j = 0; j < column; j++){
        if (j % 2 == 0)
            sb.append("\n");

        else
            sb.append("\n ");
        for(int i = 0; i < row; i++)
            sb.append("* ");
    }

    return sb.toString();
}