private void delete(String fileName) {
   try {
        File file = new File(fileName);
        if(!file.exists()){
            Toast.makeText(getApplicationContext(), "File doesn't exists", Toast.LENGTH_SHORT).show();
        } else if(file.getAbsoluteFile().delete())
            Toast.makeText(getApplicationContext(), "File has been deleted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(), "File couldn't be deleted", Toast.LENGTH_SHORT).show();
      } catch (Exception e) {
        e.printStackTrace();
        Toast.makeText(getApplicationContext(), "Такого файла не существует!", Toast.LENGTH_SHORT).show();
    }
}