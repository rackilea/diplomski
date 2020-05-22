public class FootyDraw { 

        public static void main(String[] args) { 

                String[] teams = {"Arsenal", "Chelsea", "Man United", "Liverpool"}; //array         initializer 
                List<String> list =  Arrays.asList(teams);
                Collections.shuffle(list);
                for (int i = 0; i < teams.length; i += 2) {
                    if(i + 1 < teams.length) System.out.println(teams[i] + " v " + teams[i + 1]);
                }
          }
}