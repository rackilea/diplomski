public <T extends ResponseTask> List<T> getResponse(List<Future<ResponseTask>> threadResponse) {
        List<BSLocateUserResponse> locateResponse = new ArrayList<>();
        List<LoginUser> userResponse = new ArrayList<>();
        for (Future<ResponseTask> response : threadResponse) {
            ResponseTask result = null;
            try {
                result = response.get();
            } catch (ExecutionException e) {
                // Todo Need to capture the specific exception to ignore here
                LOG.info("Exception : {}  occurred when calling multithread ", e.getMessage());
                continue;
            } catch (InterruptedException e) {
                // Restore interrupted state...
                Thread.currentThread().interrupt();
            }
            if (result instanceof BSLocateUserResponse) {
                locateResponse.add((BSLocateUserResponse) result);
            } else if (result instanceof LoginUser) {
                userResponse.add((LoginUser) result);
            }
        }
        if (locateResponse.isEmpty()) {
            return (List<T>) userResponse;
        }
        return (List<T>) locateResponse;
    }