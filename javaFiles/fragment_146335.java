PrintWriter writer = null;
          try {
              writer = new PrintWriter("VectorDump", "UTF-8");
          } catch (Exception e) {
              break;
          }

            Iterator it = vector.iterator();

          while(it.hasNext())
          {
           writer.print(
                     it.next() + " "
              );
          }

          writer.close();