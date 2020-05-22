It's because the numbers that you write are not written as strings into the txt but as raw byte value. 
Try the following code:

  BufferedWriter writer = null;
    try {
        writer = new BufferedWriter(new FileWriter("./output.txt"));
        writer.write(yourRandomNumberOfTypeInteger.toString());
    } catch (IOException e) {
        System.err.println(e);
    } finally {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

Or, if referring to your original code, write the Integer directly:
try {
            for(int i = 0; i < 10000; i ++){
                Integer randomNumber = randInt(0, 100000);
                out.write(randomNumber.toString());
            }
        }finally{
            if (out != null) {
                out.close();
            }
        }