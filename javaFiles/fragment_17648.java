List<String[]> myEntries;

int t=0;

for (String[] element:myEntries) {
                k=0;
                String[] world = new String[8];
                for (String temp:element) {

                    if (temp.startsWith("AutoTestSoftware")) {
                        int hi = Integer.parseInt(temp.split("AutoTestSoftware(?=\\d)")[1]);
                        hi += 8;
                        temp = "AutoTestSoftware" + hi;
                    }
                    world[k]=temp;
                    k++;
                }
                System.out.println(Arrays.toString(world)+"value of t: "+t);
                myEntries.set(t,world);
                t++;
            }
            System.out.println("\n\n");
            for (String[] element2 : myEntries)
            {
              System.out.println(Arrays.toString(element2));
            }