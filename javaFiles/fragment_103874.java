for (int i = 0; i < ordersList.size(); i++) {
    if (ordersList.get(i).getUser_id() ==
            ordersList.get(i).getPersonsList().get(0).getId()) {
        System.out.println("Order: "+ ordersList.get(i).getId()+
            "Person"+ ordersList.get(i).getPersonsList().get(0).getName());
    }
}