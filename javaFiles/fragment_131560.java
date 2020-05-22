public static void main(String[] a)
    {
        ArrayList<Tests> ar=read("E:/score.txt");
        if (ar != null){  
            System.out.println("First_Name\tLast_Name\tTest1\t\tTest2\t\tTest3\t\tTest4 \t\tTest5\t\tAverage\t\tGrade");
            for(Tests e:ar)
            {
                System.out.println(e);
            }
        } else {
            System.out.println("Could not read file");
        }
    }