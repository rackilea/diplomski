public static void main(String[] args) throws IOException {
            Map<Integer, String> map = new HashMap<Integer, String>();
            BufferedReader br = new BufferedReader(new FileReader("movieReviews.txt"));
            String line="";
            int i=0;
            while (line != null) {
                line = br.readLine();
                map.put(i,line);
                i++;
            }
            for(int j=0;j<map.size();j++){
                System.out.println(map.get(j));
            }
        }