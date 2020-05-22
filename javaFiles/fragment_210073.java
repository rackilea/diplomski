Scanner sc = new Scanner(rede);
    for(int i = 0; i<nLinhasColunas; i++){
        for(int j = 0; j< nLinhasColunas; j++){
            Boolean b = sc.nextBoolean();
            matrix[i][j] = b;
        }
    }