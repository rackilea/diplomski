package com.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("*")  // give your url mapping  eg..//you can write for "/yoururlspec/*"
public class CommonFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String path="";
        if (request.getRequestURI().length() > request.getContextPath().length())
        {path=request.getRequestURI().substring(request.getContextPath().length()+1, request.getRequestURI().length());
        req.getRequestDispatcher(path+".jsp").forward(req, res);
        }
    }

    @Override
    public void destroy() {
    }
}