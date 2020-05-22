package com.gtac.usuario.webservice.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtac.usuario.service.UsuarioService;

@WebService(serviceName = "UsuarioWebService")
@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
@Service
public class UsuarioWebServiceImpl extends SpringBeanAutowiringSupport  {

    @Autowired
    private UsuarioService usuarioService;

    @WebMethod
    public int numero() {
        return this.usuarioService.numero();
    }

    @WebMethod(exclude=true)
    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    @WebMethod(exclude=true)
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

}