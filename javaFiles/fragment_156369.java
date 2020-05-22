package com.gmail.at.mironiuk.kacper.stack.overflow.wtf;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/data")
public class Receiver {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response storeData(Data data) {
        Database db = new Database();
        SDBean bean = new SDBean();

        String macD = data.getMac();
        int routeD = data.getRoute();
        double latD = data.getLatitude();
        double longD = data.getLongitude();
        double speedD = data.getSpeed();

        if (routeD != 0) { // here you always will have null or empty case you only set your status here
            bean.status = db.insertData(macD, routeD, latD, longD); // In this if try to add sth to your list
            bean.status = 204;
            return Response.status(bean.status).entity(bean.toJson()).build(); //Expected result {"status":"204", "routes": []}
        } else { // here your List will be this whats you returns from
            bean.routes = db.detectRoute(latD, longD); // <- this function and i don't know what function returns
            return Response.status(bean.status).entity(bean.toJson()).build(); //Expected result {"status":"204", "routes": [?,?,?]}
        }
    }

}