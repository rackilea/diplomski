main[1] list
2    
3    public class Clazz {
4    
5        public static void main(String[] args) throws Exception {
6 =>         new Clazz().method();
7        }
8        
9        public void method() throws Exception {
10            Clazz.staticMethod(() -> {
11                Integer x = 1;
main[1] list 12
8        
9        public void method() throws Exception {
10            Clazz.staticMethod(() -> {
11                Integer x = 1;
12 =>             Long y = 2L;
13                y = x * y; // I need a Break point here
14                return y;
15            });
16        }
17