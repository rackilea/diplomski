double[] xadj = new double[10],yadj = new double[10];
        for(int i=0;i< x.length ;i++){
            xadj[i]=x[i]-xbar;
            yadj[i]=y[i]-ybar;
        }

        System.out.println(Arrays.toString(xadj));
        System.out.println(Arrays.toString(xadj));