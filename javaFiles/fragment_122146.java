public static void main(String[] args) {
            List<Number> list = new ArrayList<Number>();
            list.add(5);
            list.add(5.4);
            list.add(1.2);

            System.out.println(list);

            double sum = 0;
            for(Number i : list){
                sum += i.doubleValue();
            }

            System.out.println("sum is " + sum);
        }