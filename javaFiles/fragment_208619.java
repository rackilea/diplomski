for(i = 1 ; i < 100 ; i ++){ // for x1 to x99
        y[i] = y[i-1] + h * Math.abs(functionof(x[i-1],y[i-1])); 
        out.print("y");
        out.print(i-1);
        out.print("=");
        out.print(y[i-1]);
}