String str = new Gson().toJson(yourMap);
    File file = new File(fileName);
    try(FileOutputStream stream = new FileOutputStream(file)) {
        file.createNewFile();
        stream.write(str.getBytes());
    }catch (IOException e){
        System.out.println("can't write to file");
    }