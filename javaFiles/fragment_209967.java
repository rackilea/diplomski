try
  {
     Scanner inFile = new Scanner(new File("FIFA.txt"));
     while (inFile.hasNext())
     {
        line = inFile.nextLine();
        //System.out.println(line);
        Scanner sc = new Scanner(line).useDelimiter("#");
        ranking = sc.nextInt();
        team = sc.next();
        points = sc.nextDouble();
        group = sc.next().charAt(0);
        sizeTeam = 0; // this is the only change needed
        while (sc.hasNext())
        {
           player = sc.next();
           position = sc.next();
           playerArr[sizeTeam] = new Player(player, position);
           sizeTeam++;
        }//while sc
        teamArr[size] = new Team(team, playerArr, sizeTeam, group, ranking,points);
        size++;
        sc.close();
     }//end while inFile
     inFile.close();
  }