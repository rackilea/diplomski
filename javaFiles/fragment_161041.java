String temp = "12:00 PM - 4:00 PM (MON-FRI), 3PM - 6 PM (WED), 4 PM- 8PM (TUE,THU)";
    String[] partsOfInput = temp.split("\\),");
    String part1 = partsOfInput[0]+")";
    String part2 = partsOfInput[1]+")";
    String part3 = partsOfInput[2];
    if(part3!=null)
    {
        System.out.println("part1-->"+part1);
       System.out.println("Part2->"+part2);
       System.out.println("part3-->"+part3);
    }
       else
        System.out.println(part1+part2);
}