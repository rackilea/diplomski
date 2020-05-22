int values[][] = new int[][] { { 1, 2
            }, { 3, 4
            }, { 5, 6
            }
      };
      int[] v = Arrays.stream(values).reduce(new int[] { 0, 0
      }, (a, b) ->
      {
         a[0] += b[0];
         a[1] += b[1];
         return a;
      });
      System.out.println(Arrays.toString(v));