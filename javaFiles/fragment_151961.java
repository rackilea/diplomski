public void GenerGame(){

    Random r = new Random();
    int game = r.nextInt(100);

    if (game < 60){ // 60%
        // do something
    }
    else if (game < 79){ // 19%
        // do something
    }
    else if (game < 93){ // 14%
        // do something
    }
    else { // 7%
        // do something
    }
}