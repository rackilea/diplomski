import java.util.*;

class SO11703827 {

    private static ArrayList<Integer> bestRoute;

    public static void bruteForceFindBestRoute
        (ArrayList<Integer> r,
         ArrayList<Integer> citiesNotInRoute)
    {
        if(!citiesNotInRoute.isEmpty())
        {
            for(int i = 0; i<citiesNotInRoute.size(); i++)
            {
                Integer justRemoved =
                    (Integer) citiesNotInRoute.remove(0);
                ArrayList<Integer> newRoute =
                    (ArrayList<Integer>) r.clone();
                newRoute.add(justRemoved);

                bruteForceFindBestRoute(newRoute, citiesNotInRoute);
                citiesNotInRoute.add(justRemoved);
            }
        }
        else //if(citiesNotInRoute.isEmpty())
        {
            if(isBestRoute(r))
                bestRoute = r;
        }

    }

    private static boolean isBestRoute(ArrayList<Integer> r) {
        System.out.println(r.toString());
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> lst = new ArrayList<Integer>();
        for (int i = 0; i < 6; ++i)
            lst.add(i);
        ArrayList<Integer> route = new ArrayList<Integer>();
        bruteForceFindBestRoute(route, lst);
    }
}