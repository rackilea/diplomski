package com.coreservlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.AbstractDocument.BranchElement;

import org.json.JSONException;
import org.json.JSONObject;

@WebServlet("/servlet")
public class JSONServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        String user ="";
        String pass = "";

        System.out.println("In do Get");
        response.setContentType("application/json");

        try {
            JSONObject jsonRequest = new JSONObject(request.getParameter("TAG"));//from url in app
            System.out.println(jsonRequest);
            user = jsonRequest.getString("user");
            pass = jsonRequest.getString("pass");

            System.out.println("UserName: "+user+" Password: "+pass);

            //send back to app
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("ok","ok");

            JSONObject replyJSON = new JSONObject(map);

            PrintWriter printW = response.getWriter();
            printW.println(replyJSON);

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {//essentioall dummy
        doGet(request, response);
    }
}