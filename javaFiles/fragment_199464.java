static void sumToValue(int limit, int sum, int count, List<Integer> resultIP) {
    if (limit >= 0 && sum == 0 && count == 0) {
        // print resultIP, because it is one of the answers.
        System.out.println("sum(" + Arrays.toString(resultIP.toArray()) + ")");
    } else if (limit <= 0 || count == 0 || sum <= 0) {
        // not what we want
        return;
    } else {
        // Two options: choose current limit number or not
        sumToValue(limit - 1, sum, count, resultIP);// Not choose the limit
                                                    // number

        // or choose the limit number
        List<Integer> resultNext = new ArrayList<Integer>(resultIP);// copy
                                                                    // resultIP
        resultNext.add(limit);
        sumToValue(limit - 1, sum - limit, count - 1, resultNext);
    }
}