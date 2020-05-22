public static void main ( String[] args )
    {
        //setting up initial array 'heightMap' (you can name it like you want)
        float[][] f = { { 2, 2, 3, 3 }, { 2, 2, 3, 3 }, { 0, 0, 1, 1 }, { 0, 0, 1, 1 } };

        float[][] f2 = splitHeightMap ( f, TerrainQuadrant.BotttomRight );
        for ( float[] floats : f2 )
        {
            System.out.println ( Arrays.toString ( floats ) );
        }
    }

    protected static float[][] splitHeightMap ( float[][] heightMap, TerrainQuadrant quadrant )
    {
        //this gives you half of the 'heightMap' length
        int newSize = heightMap.length >> 1;
        float[][] newHeightMap = new float[ newSize ][ newSize ];

        //its your offsets, indicating from what place to start iteration
        int xOffset = 0;
        int yOffset = newSize;

        //its max values to reach while iterating
        int xRestriction = newSize;
        int yRestriction = heightMap.length;

        //setting up params according to 'quadrant'
        switch ( quadrant )
        {
            case BottomRight:
                xOffset = newSize;
                yOffset = newSize;

                xRestriction = heightMap.length;
                break;
            case TopLeft:
                yOffset = 0;

                yRestriction = newSize;
                break;
            case TopRight:
                yOffset = 0;
                xOffset = newSize;

                xRestriction = heightMap.length;
                yRestriction = newSize;
                break;
            default:
                break;
        }

        //counters not to reach new array bounds
        int xCount = 0, yCount = 0;
        for ( int y = yOffset; y < yRestriction; y++ )
        {
            //taking row at 'y' position
            float[] row = heightMap[ y ];
            for ( int x = xOffset; x < xRestriction; x++ )
            {
                //taking value from 'y' row at 'x' position.
                float value = row[ x ];

                //set fetched value to new map.
                newHeightMap[ yCount ][ xCount ] = value;

                //increase x position, but do not touch row
                xCount++;
            }

            //new row - new 'x' position
            xCount = 0;
            yCount++;
        }
        return newHeightMap;
    }