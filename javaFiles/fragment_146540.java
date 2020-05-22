package com.xmlrpc.client;

import java.net.URL;
import java.util.HashMap;
import java.util.Vector;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class Create {

public static void main(String args[]) throws Exception {

Vector params1 = new Vector();
params1.addElement("openerpdb");
params1.addElement("admin");
params1.addElement("admin");

XmlRpcClient xmlrpcLogin = new XmlRpcClient();
XmlRpcClientConfigImpl xmlrpcConfigLogin = new XmlRpcClientConfigImpl();
xmlrpcConfigLogin.setEnabledForExtensions(true);
xmlrpcConfigLogin.setServerURL(new URL("http", "localhost", 8069, "/xmlrpc/common"));
xmlrpcLogin.setConfig(xmlrpcConfigLogin);

Object id = xmlrpcLogin.execute("login", params1);
System.out.println("Login Id : " + id.toString());

System.out.println("------------------------");

XmlRpcClient client = new XmlRpcClient();
XmlRpcClientConfigImpl clientConfig = new XmlRpcClientConfigImpl();
clientConfig.setEnabledForExtensions(true);
clientConfig.setServerURL(new URL("http", "localhost", 8069, "/xmlrpc/object"));
client.setConfig(clientConfig);

HashMap<Object, Object> params = new HashMap<Object, Object>();

params.put("street", "Edamon3");
params.put("partner_id", "24");
params.put("city", "Punalur3");
params.put("name", "ShameerHabeeb3");

Vector<Object> arg = new Vector<Object>();

arg.add("openerpdb");
arg.add(1);
arg.add("admin");
arg.add("res.partner.address");
arg.add("create");
arg.add(params);

Object ret_id = client.execute("execute", arg);
System.out.println("Created new partner address with id :" + ret_id.toString());

}