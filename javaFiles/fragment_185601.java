private void serializeQuotes(){
         FileOutputStream fos;
         File file = new File(Constants.FILENAME);
         if (file.exists()) file.delete();
        try {
            fos = openFileOutput(file, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(quotes); 
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }