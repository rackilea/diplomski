public static int numberOfPoints = -1, p=-1, q=-1;

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Integer> dots = new ArrayList<>();
        int c = 0;
        File file = new File("D:\\ALGORTHIMS\\MASTER LEVEL\\dr. khaled\\assignment 3\\a.txt");
        BufferedReader reader = null;


        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;
            while ((text = reader.readLine()) != null) {

                try {
                    if(c==0)
                    { numberOfPoints=Integer.parseInt(text); c=1;}
                    if(c==1)
                    { p=Integer.parseInt(text);c=2;}
                    if(c==2)
                        q=Integer.parseInt(text);

                } catch (NumberFormatException e) {

                    Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(text);
        while (m.find()) {

           dots.add(Integer.parseInt(m.group(1)));
        }

                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.print(e);
            }
        }