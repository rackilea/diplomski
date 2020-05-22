else
    {
        dive = Array2[2]/Array1[2];
        for (int j = 0; j<Array1.length;j++)
            for (int l = 0; l<Array2.length;l++)
                Array2[l] = Array2[l]- dive*Array1[j];
    }