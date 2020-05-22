private static MapData createMap( Scanner scanner )
{
    System.out.println( "Enter Height" );
    int rows = scanner.nextInt();

    System.out.println( "Enter Width" );
    int columns = scanner.nextInt();

    int[][] map = new int[rows][columns];
    MapData data = new MapData( rows, columns, map );
    return data;
}