List<Users> u = new ArrayList<Users>();  
u.add(new Users(1, 5));  
u.add(new Users(2, 4));  
u.add(new Users(3, 8));  
Collections.shuffle(u);  

List<Integer> output = new ArrayList<Integer>();  
for (Users us1 : u) {  
    int si1 = us1.i;  
    int di = us1.i;  
    for (int j = 0; j < si1; j++) {  
        System.out.println("cf:" + di);  
        output.add(di);  
    }  
}  

Integer[] result = output.toArray(new Integer[output.size()]);