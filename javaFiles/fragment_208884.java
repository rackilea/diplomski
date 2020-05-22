catch(err:Error)
{
    var e:AdEvent = null;
    if(err.errorID == 3500)
        e = new AdEvent(AdEvent.INIT_FAIL, "Isn't it clear, that ANDROID Extension will NOT work on PC/Mac???");
    else
        e = new AdEvent(AdEvent.INIT_FAIL, "ANE was not properly added to your project.");
    this.dispatchEvent(e);
}