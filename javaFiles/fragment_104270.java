int counter = 0;
while (true){
    try{
        // do something
        break;
    } catch (IOException e) {
        e.printStackTrace();
        counter++;

        if (counter >= 10)
            throw new RuntimeException(e);
    }
}