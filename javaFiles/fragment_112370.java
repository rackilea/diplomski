package com.john.rest.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jackson.map.annotate.JsonView;
import org.springframework.stereotype.Component;

import com.midtronics.esp.common.EspException;
import com.midtronics.esp.common.SystemObject;
import com.midtronics.esp.mobile.model.SystemObjectView;
import com.midtronics.esp.model.accesscontrol.AccessControlBean;
import com.midtronics.esp.model.site.SiteBean;

@Component
@Path("/hierarchy")
public class Hierarchy {

    // Allows to insert contextual objects into the class, 
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;

    @Context
    Request request;

    // Return the list of sites
    @GET
    @Path("sites")
    @Produces(MediaType.APPLICATION_JSON)
    @JsonView({SystemObjectView.ObjectList.class})
    public List<SystemObject> listSite(
            @HeaderParam("userId") String userId, 
            @HeaderParam("password") String password) {
        ArrayList<SystemObject> sites= new ArrayList<SystemObject>();

        try{
            if(!AccessControlBean.CheckUser(userId, password)){
                throw new WebApplicationException(401);
            }
            SystemObject.GetSiteListByPage(sites, 2, 3);

            return sites;
        } catch(EspException e){
            throw new WebApplicationException(401);
        } catch (Exception e) {
            throw new WebApplicationException(500);
        }
    }

    // Return the number of sites
    @GET
    @Path("sites/total")
    @Produces(MediaType.TEXT_PLAIN)
    public String getSiteNumber(@HeaderParam("userId") String userId, 
            @HeaderParam("password") String password) {
        try{
            return Integer.toString(SiteBean.GetSiteTotal()); 
        } catch(EspException e){
            throw new WebApplicationException(401);
        } catch (Exception e) {
            throw new WebApplicationException(500);
        }
    }

}