public static void save(Mat mat, String name)
        {
            File file = new File(path, name);
            int length = (int) (mat.total() * mat.elemSize());
            byte buffer[] = new byte[length];
            mat.get(0, 0, buffer);
            try
                {
                    FileUtils.writeByteArrayToFile(file, buffer);
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
        }

 public static Mat load(String name)
        {
            File file = new File(path, name);
            byte[] buffer = new byte[0];
            try
                {
                    buffer = FileUtils.readFileToByteArray(file);
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            Mat mat = new Mat(row, col, type);
            mat.put(0, 0, buffer);
            return mat;
        }