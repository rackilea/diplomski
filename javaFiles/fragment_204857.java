public <T extends BaseDTO> BaseService<T> resolve(T object) {
        if (object instanceof AaaDTO) {
            return (BaseService<T>) aaaService;
        } else if (object instanceof BbbDTO) {
            return (BaseService<T>) bbbService;
        } else {
            throw new IllegalArgumentException();
        }
    }