public class Global extends GlobalSettings {


@Override
public Promise<Result> onError(RequestHeader arg0, Throwable arg1) {
    super.onError(arg0, arg1);
    return F.Promise.promise(()->{return play.mvc.Results.noContent();});
}

@Override
public Promise<Result> onBadRequest(RequestHeader arg0, String arg1) {
     super.onBadRequest(arg0, arg1);
    return F.Promise.promise(()->{return play.mvc.Results.noContent();});
}


}