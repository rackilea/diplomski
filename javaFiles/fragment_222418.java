public class Executor  {

    List<BaseRequest<? extends BaseObj>> mRequests = new ArrayList<>();

    public Executor() {
    }

    public <T extends BaseObj> void add(final BaseRequest<T> request) {
        mRequests.add(request);
    }

    public void execute() {
        for (BaseRequest<? extends BaseObj> r : mRequests) {
            // DO SOMETHING WITH r
        }
    }
}

class BaseRequest<T> {}

class BaseObj {}