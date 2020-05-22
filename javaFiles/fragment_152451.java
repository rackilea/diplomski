public void delRouter(String routerNum){
    Router router = (Router) ht.get(key);
    if (router.getRouterNum().equals(routerNum)){
        ht.remove(routerNum);
    }
}