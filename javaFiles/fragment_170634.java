Try this :    

                String axis="x=-0.125 y=0.9375 z=0.375";
                String[] tempArr=axis.split(" ");
                ArrayList arr=new ArrayList<String>();
                for(String a:tempArr){
                    arr.add(a.split("=")[1].trim());
                }
                System.out.println(arr);