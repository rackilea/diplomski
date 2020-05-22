float[][] bounds = {{1,2,3,4}, {5,5,7,8} };
        String[]  names  = { "foo", "bar"};

        for (int i = 0; i < bounds.length; i++)
        {
            float[] rect = bounds[i];
            addActor(new GameButton(new Rectangle(rect[0], rect[1], rect[2], rect[3]), names[i]));
        }