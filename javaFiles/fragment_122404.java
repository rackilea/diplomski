String routeCode = routeList.get(arg0.getId()).getRouteCode();
index = -1;
for(int i = 0; i < selectedRoutes.size(); i++) {
    if(routeCode.equals(selectedRoutes.get(i)) {
        index = i;
            break;
    }
}
if(index > -1)
    selectedRoutes.remove(index);
Log.i("remove", routeCode);
System.out.println("----remove ----" + selectedRoutes);