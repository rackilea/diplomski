for (int j=0;j<newN;j++){
        for (int k=0;k<newN;k++){
            dft[j][k] = omega.pow((j*k)%newN);
            //System.out.println(dft[j][k]);
        }
    }