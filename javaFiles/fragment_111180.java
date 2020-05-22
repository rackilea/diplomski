class TestClass {
public static void main(String args[] ) throws Exception {

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

int T = Integer.parseInt(br.readLine());
if(T<=10 && T>=1)   {
for (int i = 0; i < T; i++) {
   int count=0;
   int numOfPonds = Integer.parseInt(br.readLine());
    if(numOfPonds<=100000 && numOfPonds>=1){  
   String[] str ;

Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    for(int j=0 ; j< numOfPonds ;j++)
            {   
                str = br.readLine().split(" ");
                int foodType = Integer.parseInt(str[0]);
                int PokeType = Integer.parseInt(str[1]);

                if(foodType<=1000000 && PokeType<=1000000 && foodType>=1 && PokeType>=1 && foodType != PokeType){

                if(map.containsKey(foodType))
                {
                    int x = map.get(Integer.valueOf(foodType));
                    x++;
                    map.put(foodType,x);
                }
                else
                {   map.put(foodType,1);
                }

                if(!(map.containsKey(PokeType)))                        
                                count++;

                else 
                    {   int x = map.get(Integer.valueOf(PokeType));
                        x--;

                        if(x==0)
                        map.remove(PokeType);

                        else
                        map.put(PokeType,x);

                        }

                }
            }
     }
   System.out.println(count);
  }
}
}
}