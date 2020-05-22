String[] xmls = new String[3];

    GetXML taskA = new GetXML();
    try {
        xmls = taskA.execute().get();
    } catch (InterruptedException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    } catch (ExecutionException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }