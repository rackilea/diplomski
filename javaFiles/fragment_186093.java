int[] result2 =
               Arrays.stream(values).reduce(new int[values[0].length], (a, b) ->
            {
               for (int i = 0; i < values[0].length; ++i) {
                  a[i] += b[i];
               }
               return a;
            });