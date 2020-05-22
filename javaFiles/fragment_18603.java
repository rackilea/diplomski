List<ErroCodeMessage> errors = new ArrayList<>();
    //... add ErroCodeMessages
    Map<Integer, Integer> stat = new HashMap<>();

    for (ErroCodeMessage error : errors) {
        if (stat.get(error.getErrorCode()) != null) {
            stat.put(error.getErrorCode(), stat.get(error.getErrorCode()) + 1);
        } else {
            stat.put(error.getErrorCode(), 1);
        }
    }