if (score>=0 && score<3) {
        int loadG1 = generateG1.nextInt(99999)+10000;
        number.setText(""+loadG1);
    }
    else if (score>=3 && score<6){
        int loadG1 = generateG1.nextInt(999999)+100000;
        number.setText(""+loadG1);
    }
    else if (score>=6 && score<10){
        int loadG1 = generateG1.nextInt(9999999)+1000000;
        number.setText(""+loadG1);
    }
    else if (score>=10){
        int loadG1 = generateG1.nextInt(99999999)+10000000;
        number.setText(""+loadG1);
    }