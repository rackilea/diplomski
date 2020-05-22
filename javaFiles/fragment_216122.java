UserGetDevicesResponse.UserGetDevicesResult j = dp.userGetDevices();
    List<Object> n = j.getContent();
    if (n.size() > 0)
    {
        Node z = (Node)n.get(0);
        System.out.println(nodeToString(z));
    }