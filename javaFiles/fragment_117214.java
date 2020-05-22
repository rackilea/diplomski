public static void main(String[] args) {

    String in = "host 0 4 3 9 router 4 9 2 lan 1 3 4 7";

    List<String> storage = Arrays.asList(in.split(" "));

    boolean isHost = false;
    boolean isRouter = false;
    boolean isLan = false;

    List<String> hostList = new ArrayList<String>();
    List<String> routerList = new ArrayList<String>();
    List<String> lanList = new ArrayList<String>();

    for(String val : storage){
        if("host".equals(val)){
            isHost = true;
            continue;
        }
        else if("router".equals(val)){
            isRouter = true;
            isHost = false; 
            continue;
        }
        else if("lan".equals(val)){
            isHost = false;
            isRouter = false;
            isLan = true;
            continue;
            }

        if(isHost){             
            hostList.add(val);
        }
        else if(isRouter){              
            routerList.add(val);
        }
        else if(isLan){             
            lanList.add(val);
        }
    }

    System.out.print("Host: "); System.out.println(hostList);
    System.out.print("Router: "); System.out.println(routerList);
    System.out.print("Lan: "); System.out.println(lanList);

}