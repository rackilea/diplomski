} catch (IOException e){
    e.printStackTrace();
} finally {
    if (fileWriter != null) {
        fileWriter.close();
    }
}