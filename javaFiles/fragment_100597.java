package test;

import jsinterop.annotations.JsType;

@JsType
class XRequest{

    private String url;
    public XRequest(String url)
    {
    this.url=url;

    }

    public String testGet()
    {
    return url;
    }

    };
@JsType
class Xlib{
    public static XRequest get(String url){
        return new Xequest(url);
    };
}