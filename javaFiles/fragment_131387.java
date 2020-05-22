BufferedReader br = new BufferedReader(new FileReader("info.txt"));
ArrayList<Double> ball = new ArrayList<>();
ArrayList<Double[]> box = new ArrayList<>();

String nums;
while((nums = br.readLine()) != null){      
    String numbers[] = nums.split(" ");
    if(numbers.length == 3){
        Double[] box_row = new Double[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            box_row[i] = Double.parseDouble(numbers[i]);
        }
        box.add(box_row);
    }else if(numbers.length == 1){
        ball.add(Double.parseDouble(numbers[0]));
    }
}

System.out.println("Box Array");
for(Double[] element: box){
    System.out.println(Arrays.toString(element));
}
System.out.println("Ball Array");
System.out.println(ball.toString());