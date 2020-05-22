package com.pinhassi.android.utilslib;

import java.util.Date;
import java.util.List;

import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class MyPersistentCookieStore extends BasicCookieStore {
private static final String COOKIES_LIST = "CookiesList";
private static final String COOKIES_NAMES = "CookiesNames";

private Context mContext;
/**
 * 
 */
public MyPersistentCookieStore(Context context) {
    super();
    mContext = context;
    load();
}

@Override
public synchronized void clear(){
    super.clear();
    save();
}

@Override
public synchronized boolean clearExpired(Date date){
    boolean res = super.clearExpired(date);
    save();
    return res;
}

@Override
public synchronized void addCookie(Cookie cookie){
    super.addCookie(cookie);
    save();
}

@Override
public synchronized void addCookies(Cookie[] cookie){
    super.addCookies(cookie);
    save();
}

public synchronized void save()
{
    Editor editor = mContext.getSharedPreferences(COOKIES_LIST, Context.MODE_PRIVATE).edit();
    editor.clear();
    List <Cookie> cookies = this.getCookies();
    StringBuilder sb = new StringBuilder();
    for (Cookie cookie : cookies)
    {
        editor.putString(cookie.getName(),cookie.getValue());
        sb.append(cookie.getName()+";");
    }
    editor.putString(COOKIES_NAMES,sb.toString());
    editor.commit();
}

public synchronized void load()
{
    SharedPreferences prefs = mContext.getSharedPreferences(COOKIES_LIST, Context.MODE_PRIVATE);
    String [] cookies = prefs.getString(COOKIES_NAMES,"").split(";");
    for (String cookieName : cookies){
        String cookieValue = prefs.getString(cookieName, null);
        if (cookieValue!=null)
            super.addCookie(new BasicClientCookie(cookieName,cookieValue));
    }

    }

}