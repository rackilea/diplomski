void Grading(){

    FileReader fr = null;
    try {
        fr = new FileReader("score.txt");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    BufferedReader br = new BufferedReader(fr);
}