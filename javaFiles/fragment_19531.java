public static void main(String[]args)
      {
        String csv = "Sue,5,true,3";
        Scanner sc = new Scanner(csv);
        sc.useDelimiter(",");
        sc.next();
        int age = sc.nextInt();
        System.out.println(age);
      }