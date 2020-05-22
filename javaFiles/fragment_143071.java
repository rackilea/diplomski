try {

        File file = new File("file.txt");
        file.createNewFile();

        FileWriter writer = new FileWriter(file);

        for (int dx = 1; dx <= 100; dx++) {
            String sizeX = (String.valueOf(Myclass.myFunction(a, b));
            writer.write(sizeX);
        }

        writer.flush();
        writer.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}

private static Random random = new Random();

public static int myFunction(int a, int b){
    return (int) (random.myFunction(a*b);
}