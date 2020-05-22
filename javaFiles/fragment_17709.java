String separator = "";
            for (int d = 2; d <= 9; ++d) {
              if (veri%d==0) {
                  System.out.print(separator);
                  System.out.print(d);
                  separator = ", ";
              }
            }